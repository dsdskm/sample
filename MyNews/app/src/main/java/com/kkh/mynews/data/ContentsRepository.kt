package com.kkh.mynews.data

import android.database.Cursor
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
import com.kkh.mynews.data.item.cafe.model.CafeModel
import com.kkh.mynews.data.item.dict.dao.DictItemsDao
import com.kkh.mynews.data.item.dict.model.DictModel
import com.kkh.mynews.data.item.image.dao.ImageItemsDao
import com.kkh.mynews.data.item.image.model.ImageModel
import com.kkh.mynews.data.item.know.dao.KnowItemsDao
import com.kkh.mynews.data.item.know.model.KnowModel
import com.kkh.mynews.data.item.location.dao.LocationItemsDao
import com.kkh.mynews.data.item.location.model.LocationModel
import com.kkh.mynews.data.item.movie.dao.MovieItemsDao
import com.kkh.mynews.data.item.movie.model.MovieModel
import com.kkh.mynews.data.item.news.model.NewsModel
import com.kkh.mynews.data.item.refer.dao.ReferItemsDao
import com.kkh.mynews.data.item.refer.model.ReferModel
import com.kkh.mynews.data.item.search.model.SearchModel
import com.kkh.mynews.data.item.shopping.dao.SearchDao
import com.kkh.mynews.data.item.web.dao.WebItemsDao
import com.kkh.mynews.data.item.web.model.WebModel
import com.kkh.mynews.network.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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

    var mBlogItemsDao: BlogItemsDao
    var mBookItemsDao: BookItemsDao
    var mCafeItemsDao: CafeItemsDao
    var mDictItemsDao: DictItemsDao
    var mImageItemsDao: ImageItemsDao
    var mKnowItemsDao: KnowItemsDao
    var mLocationItemsDao: LocationItemsDao
    var mMovieItemsDao: MovieItemsDao
    var mNewsItemsDao: NewsItemsDao
    var mReferItemsDao: ReferItemsDao
    var mShoppingItemsDao: ShoppingItemsDao
    var mWebDao: WebItemsDao
    var mKeywordDao: KeywordDao
    var mSearchDao: SearchDao

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
        mWebDao = mDatabase.webItemsDao()
        mKeywordDao = mDatabase.keywordDao()
        mSearchDao = mDatabase.searchModelDao()
    }

    fun requestRefer(query: String, count: Int) {
        Log.d(TAG, "requestRefer")
        mWebService.getRefer(query, count).enqueue(object : Callback<ReferModel> {
            override fun onResponse(call: Call<ReferModel>, response: Response<ReferModel>) {
                Log.d(TAG, "requestRefer onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mReferItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "requestRefer $it")
                        mReferItemsDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<ReferModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestRefer onFailure : " + t.message)
            }

        })
    }

    fun requestWeb(query: String, count: Int) {
        Log.d(TAG, "requestWeb")
        mWebService.getWeb(query, count).enqueue(object : Callback<WebModel> {
            override fun onResponse(call: Call<WebModel>, response: Response<WebModel>) {
                Log.d(TAG, "requestWeb onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mWebDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "requestWeb $it")
                        mWebDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<WebModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestWeb onFailure : " + t.message)
            }

        })
    }

    fun requestLocal(query: String, count: Int) {
        Log.d(TAG, "requestLocal")
        mWebService.getLocal(query, count).enqueue(object : Callback<LocationModel> {
            override fun onResponse(call: Call<LocationModel>, response: Response<LocationModel>) {
                Log.d(TAG, "requestLocal onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mLocationItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "requestLocal $it")
                        mLocationItemsDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<LocationModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestLocal onFailure : " + t.message)
            }

        })
    }

    fun requestKnow(query: String, count: Int) {
        Log.d(TAG, "requestKnow")
        mWebService.getKnow(query, count).enqueue(object : Callback<KnowModel> {
            override fun onResponse(call: Call<KnowModel>, response: Response<KnowModel>) {
                Log.d(TAG, "requestKnow onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mKnowItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "requestKnow $it")
                        mKnowItemsDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<KnowModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestCafe onFailure : " + t.message)
            }

        })
    }

    fun requestCafe(query: String, count: Int) {
        Log.d(TAG, "requestCafe")
        mWebService.getCafe(query, count).enqueue(object : Callback<CafeModel> {
            override fun onResponse(call: Call<CafeModel>, response: Response<CafeModel>) {
                Log.d(TAG, "requestCafe onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mCafeItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "requestDict $it")
                        mCafeItemsDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<CafeModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestCafe onFailure : " + t.message)
            }

        })
    }

    fun requestDict(query: String, count: Int) {
        Log.d(TAG, "requestDict");
        mWebService.getDict(query, count).enqueue(object : Callback<DictModel> {
            override fun onResponse(call: Call<DictModel>, response: Response<DictModel>) {
                Log.d(TAG, "requestDict onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mDictItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "requestDict $it")
                        mDictItemsDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<DictModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestDict onFailure : " + t.message)
            }

        })
    }


    fun requestMovie(query: String, count: Int) {
        Log.d(TAG, "requestMovie");
        mWebService.getMovie(query, count).enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                Log.d(TAG, "requestMovie onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
                    GlobalScope.launch(Dispatchers.IO) {
                        mMovieItemsDao.deleteAll()
                        for (data in it) {
                            data.query = query
                        }
                        Log.d(TAG, "updatelist $it")
                        mMovieItemsDao.insert(it)
                    }
                }

            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                t.printStackTrace()
                Log.d(TAG, "requestMovie onFailure : " + t.message)
            }

        })

    }


    fun requestImage(query: String, count: Int, filter: String) {
        Log.d(TAG, "requestImage")
        mWebService.getImage(query, count, "sim", filter)
            .enqueue(object : Callback<ImageModel> {
                override fun onFailure(call: Call<ImageModel>, t: Throwable) {
                    t.printStackTrace()
                    Log.d(TAG, "requestImage onFailure : " + t.message)
                }

                override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                    Log.d(TAG, "requestImage onResponse : " + response.body().toString())
                    val model = response.body()
                    model?.items?.let {
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

    fun requestBook(query: String, count: Int) {
        Log.d(TAG, "requestBook")
        mWebService.getSearchBook(query, count, "sim")
            .enqueue(object : Callback<BookModel> {
                override fun onFailure(call: Call<BookModel>, t: Throwable) {
                    t.printStackTrace()
                    Log.d(TAG, "requestBook onFailure : " + t.message)
                }

                override fun onResponse(call: Call<BookModel>, response: Response<BookModel>) {
                    Log.d(TAG, "requestBook onResponse : " + response.body().toString())
                    val model = response.body()
                    model?.items?.let {
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


    fun requestBlog(query: String, count: Int) {
        Log.d(TAG, "requestBlog")
        mWebService.getBlog(query, count, "sim").enqueue(object : Callback<BlogModel> {
            override fun onFailure(call: Call<BlogModel>, t: Throwable) {
                Log.d(TAG, "requestBlog onFailure : " + t.message)
            }

            override fun onResponse(call: Call<BlogModel>, response: Response<BlogModel>) {
                Log.d(TAG, "requestBlog onResponse : " + response.body().toString())
                val model = response.body()
                model?.items?.let {
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


    fun requestShopping(query: String, count: Int) {
        Log.d(TAG, "requestShopping")
        mWebService.getShopping(query, count, "sim")
            .enqueue(object : Callback<ShoppingModel> {
                override fun onFailure(call: Call<ShoppingModel>, t: Throwable) {
                    Log.d(TAG, "requestShopping onFailure : " + t.message)
                }

                override fun onResponse(
                    call: Call<ShoppingModel>,
                    response: Response<ShoppingModel>
                ) {
                    Log.d(TAG, "requestShopping onResponse : " + response.body().toString())
                    val model = response.body()
                    model?.items?.let {
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

    fun requestNews(query: String, count: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            mWebService.getSearchNews(query, count).enqueue(object :
                Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    Log.d(TAG, "onResponse : " + response.body().toString())
                    val model = response.body()
                    model?.items?.let {
                        GlobalScope.launch(Dispatchers.IO) {
                            mNewsItemsDao.deleteAll()
                            for (data in it) {
                                data.query = query
                            }
                            Log.d(TAG, "update list $it")
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

    fun insertKeyword(data: KeywordModel) {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.insert(data)
        }
    }

    fun insertKeywordList(list: List<KeywordModel>) {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.insertAll(list)
        }
    }

    fun deleteKeyword(keyword: String) {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.deleteByKeyword(keyword)
            mNewsItemsDao.deleteAllByQuery(keyword)
        }
    }

    fun deleteKeywordAll() {
        GlobalScope.launch(Dispatchers.IO) {
            mKeywordDao.deleteAll()
        }
    }

    fun deleteAll() {
        GlobalScope.launch(Dispatchers.IO) {
            mBlogItemsDao.deleteAll()
            mBookItemsDao.deleteAll()
            mCafeItemsDao.deleteAll()
            mDictItemsDao.deleteAll()
            mImageItemsDao.deleteAll()
            mKnowItemsDao.deleteAll()
            mLocationItemsDao.deleteAll()
            mMovieItemsDao.deleteAll()
            mNewsItemsDao.deleteAll()
            mReferItemsDao.deleteAll()
            mShoppingItemsDao.deleteAll()
            mWebDao.deleteAll()
            mKeywordDao.deleteAll()
            mSearchDao.deleteAll()
            mShoppingItemsDao.deleteAll()
        }
    }

    fun insertSearchModel(data: SearchModel) {
        mSearchDao.insert(data)
    }

    fun getSearchWordList(): Cursor {
        return mSearchDao.loadPagedList()
    }


}