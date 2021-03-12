package com.kkh.mynews.data

import android.util.Log
import androidx.room.Room
import com.kkh.mynews.MyNewsApplication
import com.kkh.mynews.common.Constant
import com.kkh.mynews.data.item.keyword.dao.KeywordDao
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.dao.BlogItemsDao
import com.kkh.mynews.data.item.news.dao.NewsItemsDao
import com.kkh.mynews.data.item.shopping.dao.ShoppingItemsDao
import com.kkh.mynews.data.item.shopping.model.ShoppingModel
import com.kkh.mynews.data.item.blog.model.BlogModel
import com.kkh.mynews.data.item.book.dao.BookItemsDao
import com.kkh.mynews.data.item.book.model.BookModel
import com.kkh.mynews.data.item.cafe.dao.CafeItemsDao
import com.kkh.mynews.data.item.dict.dao.DictItemsDao
import com.kkh.mynews.data.item.image.dao.ImageItemsDao
import com.kkh.mynews.data.item.image.model.ImageModel
import com.kkh.mynews.data.item.know.dao.KnowItemsDao
import com.kkh.mynews.data.item.location.dao.LocationItemsDao
import com.kkh.mynews.data.item.movie.dao.MovieItemsDao
import com.kkh.mynews.data.item.news.model.NewsModel
import com.kkh.mynews.data.item.refer.dao.ReferItemsDao
import com.kkh.mynews.network.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContentsRepository {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "NewsRepository"
        const val DEFAULT_RESULT = 10
    }

    private val mWebService: WebService = WebService.create()
    private var mDatabase: ContentsDatabase = Room.databaseBuilder(
        MyNewsApplication.getAppContext(),
        ContentsDatabase::class.java,
        "mynews.db"
    ).build()

    private var mBlogItemsDao: BlogItemsDao
    private var mBookItemsDao: BookItemsDao
    private var mCafeItemsDao: CafeItemsDao
    private var mDictItemsDao: DictItemsDao
    private var mImageItemsDao: ImageItemsDao
    private var mKnowItemsDao: KnowItemsDao
    private var mLocationItemsDao: LocationItemsDao
    private var mMovieItemsDao: MovieItemsDao
    private var mNewsItemsDao: NewsItemsDao
    private var mReferItemsDao: ReferItemsDao
    private var mShoppingItemsDao: ShoppingItemsDao
    private var mKeywordDao: KeywordDao

    init {
        mBlogItemsDao = mDatabase.blogItemsDao()
        mBookItemsDao = mDatabase.bookItemsDao()
        mCafeItemsDao = mDatabase.cafeItemsDao()
        mDictItemsDao = mDatabase.dictItemsDao()
        mImageItemsDao = mDatabase.imageItemsDao()
        mKnowItemsDao = mDatabase.knowItemsDao()
        mLocationItemsDao = mDatabase.locationItemsDao()
        mMovieItemsDao = mDatabase.movieItemsDao()
        mNewsItemsDao = mDatabase.newsItemDao()
        mShoppingItemsDao = mDatabase.shoppingItemsDao()
        mReferItemsDao = mDatabase.referItemsDao()
        mKeywordDao = mDatabase.keywordDao()
    }

    fun request

    fun requestImage(query: String, sort: String, filter: String) {
        Log.d(TAG, "requestImage")
        mWebService.getImage(query, DEFAULT_RESULT, sort, filter)
            .enqueue(object : Callback<ImageModel> {
                override fun onFailure(call: Call<ImageModel>, t: Throwable) {
                    t.printStackTrace()
                    Log.d(TAG, "requestImage onFailure : " + t.message)
                }

                override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                    Log.d(TAG, "requestImage onResponse : " + response.body().toString())
                    val blogModel = response.body()
                    blogModel!!.items?.let {
                        GlobalScope.launch(Dispatchers.IO) {
                            mImageItemsDao.deleteAll()
                            for (data in it) {
                                data.query = query
                            }
                            Log.d(TAG, "updatelist $it")
                            mImageItemsDao.insert(it)
                        }
                    }
                }

            })
    }

    fun requestBook(query: String, sort: String) {
        Log.d(TAG, "requestBook")
        mWebService.getSearchBook(query, DEFAULT_RESULT, sort)
            .enqueue(object : Callback<BookModel> {
                override fun onFailure(call: Call<BookModel>, t: Throwable) {
                    t.printStackTrace()
                    Log.d(TAG, "requestBook onFailure : " + t.message)
                }

                override fun onResponse(call: Call<BookModel>, response: Response<BookModel>) {
                    Log.d(TAG, "requestBook onResponse : " + response.body().toString())
                    val blogModel = response.body()
                    blogModel!!.items?.let {
                        GlobalScope.launch(Dispatchers.IO) {
                            mBookItemsDao.deleteAll()
                            for (data in it) {
                                data.query = query
                            }
                            Log.d(TAG, "updatelist $it")
                            mBookItemsDao.insert(it)
                        }
                    }
                }

            })
    }


    fun requestBlog(query: String, sort: String) {
        Log.d(TAG, "requestBlog")
        mWebService.getBlog(query, DEFAULT_RESULT, sort).enqueue(object : Callback<BlogModel> {
            override fun onFailure(call: Call<BlogModel>, t: Throwable) {
                Log.d(TAG, "requestBlog onFailure : " + t.message)
            }

            override fun onResponse(call: Call<BlogModel>, response: Response<BlogModel>) {
                Log.d(TAG, "requestBlog onResponse : " + response.body().toString())
                val blogModel = response.body()
                blogModel!!.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mBlogItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "updatelist $it")
                        mBlogItemsDao.insert(it)
                    }
                }
            }

        })
    }


    fun requestShopping(query: String, sort: String) {
        Log.d(TAG, "requestShopping")
        mWebService.getShopping(query, DEFAULT_RESULT, sort)
            .enqueue(object : Callback<ShoppingModel> {
                override fun onFailure(call: Call<ShoppingModel>, t: Throwable) {
                    Log.d(TAG, "requestShopping onFailure : " + t.message)
                }

                override fun onResponse(
                    call: Call<ShoppingModel>,
                    response: Response<ShoppingModel>
                ) {
                    Log.d(TAG, "requestShopping onResponse : " + response.body().toString())
                    val newsModel = response.body()
                    newsModel!!.items?.let {
                        GlobalScope.launch(Dispatchers.IO) {
                            mShoppingItemsDao.deleteAll()
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
            mWebService.getSearchNews(query, DEFAULT_RESULT).enqueue(object :
                Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    Log.d(TAG, "onResponse : " + response.body().toString())
                    val newsModel = response.body()
                    newsModel!!.items?.let {
                        GlobalScope.launch(Dispatchers.IO) {
                            mNewsItemsDao.deleteAll()
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

    fun getShoppingDao(): ShoppingItemsDao {
        return mShoppingItemsDao
    }

    fun getBlogDao(): BlogItemsDao {
        return mBlogItemsDao
    }

    fun getBookDao(): BookItemsDao {
        return mBookItemsDao
    }

    fun getImageDao(): ImageItemsDao {
        return mImageItemsDao
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

    fun deleteAll() {
        GlobalScope.launch(Dispatchers.IO) {
            mNewsItemsDao.deleteAll()
            mShoppingItemsDao.deleteAll()
        }
    }


}