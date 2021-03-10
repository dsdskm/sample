package com.kkh.mynews.data

import android.util.Log
import androidx.room.Room
import com.kkh.mynews.MyNewsApplication
import com.kkh.mynews.common.Constant
import com.kkh.mynews.item.keyword.dao.KeywordDao
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.item.news.dao.NewsItemsDao
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.item.shopping.dao.ShoppingItemsDao
import com.kkh.mynews.item.shopping.model.ShoppingModel
import com.kkh.mynews.model.NewsModel
import com.kkh.mynews.network.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "NewsRepository"
    }

    private val mWebService: WebService = WebService.create()
    private var mDatabase: NewsDatabase = Room.databaseBuilder(
        MyNewsApplication.getAppContext(),
        NewsDatabase::class.java,
        "mynews.db"
    ).build()

    private var mNewsItemsDao: NewsItemsDao
    private var mKeywordDao: KeywordDao
    private var mShoppingItemsDao: ShoppingItemsDao

    init {
        mNewsItemsDao = mDatabase.newsItemDao()
        mKeywordDao = mDatabase.keywordDao()
        mShoppingItemsDao = mDatabase.shoppingItemsDao()
    }

    fun requestShopping(query: String, sort: String) {
        Log.d(TAG,"requestShopping")
        mWebService.getShopping(query, 30, sort).enqueue(object : Callback<ShoppingModel> {
            override fun onFailure(call: Call<ShoppingModel>, t: Throwable) {
                Log.d(TAG, "requestShopping onFailure : " + t.message)
            }

            override fun onResponse(call: Call<ShoppingModel>, response: Response<ShoppingModel>) {
                Log.d(TAG, "requestShopping onResponse : " + response.body().toString())
                val newsModel = response.body()
                newsModel!!.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mShoppingItemsDao.deleteAllByQuery(query)
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "updatelist $it")
                        mShoppingItemsDao.insert(it)
                    }
                }
            }

        }
        );

    }

    fun requestNews(query: String) {
        GlobalScope.launch(Dispatchers.IO) {
            mWebService.getSearchNews(query, 10).enqueue(object :
                Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    Log.d(TAG, "onResponse : " + response.body().toString())
                    val newsModel = response.body()
                    newsModel!!.items?.let {
                        GlobalScope.launch(Dispatchers.IO) {
                            mNewsItemsDao.deleteAllByQuery(query)
                            for (data in it) {
                                data.query = query
                            }
                            Log.d(TAG, "updatelist $it")
                            mNewsItemsDao.insert(it)
                        }
                    }
                }

                override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                    Log.d(TAG, "onFailure : " + t.message)
                }
            })
        }
    }

    fun getNewsDao(): NewsItemsDao {
        return mNewsItemsDao
    }

    fun getKeyword(): Flow<List<KeywordModel>> {
        return mKeywordDao.load()
    }

    fun getShoppingDao():ShoppingItemsDao{
        return mShoppingItemsDao
    }

    fun insertKeywordList(list: List<KeywordModel>) {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.insertAll(list)
        }

    }

    fun insertKeyword(data: KeywordModel) {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.insert(data)
        }
    }

    fun deleteKeyword(keyword: String) {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.deleteByKeyword(keyword)
            mNewsItemsDao.deleteAllByQuery(keyword)
        }
    }

    fun deleteNewsAll() {
        GlobalScope.launch(Dispatchers.IO) {
            mNewsItemsDao.deleteAll()
        }
    }


}