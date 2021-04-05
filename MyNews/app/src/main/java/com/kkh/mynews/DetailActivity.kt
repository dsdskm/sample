package com.kkh.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Constant.Companion.EXTRA_QUERY
import com.kkh.mynews.data.item.blog.adapter.BlogItemsAdapter
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.adapter.BookItemsAdapter
import com.kkh.mynews.data.item.book.adapter.ImageItemsAdapter
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.cafe.adapter.CafeItemsAdapter
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.know.adapter.KnowItemsAdapter
import com.kkh.mynews.data.item.know.model.KnowItemsModel
import com.kkh.mynews.data.item.location.adapter.LocalItemsAdapter
import com.kkh.mynews.data.item.location.model.LocationItemsModel
import com.kkh.mynews.data.item.movie.adapter.MovieItemsAdapter
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.data.item.news.adapter.DictItemsAdapter
import com.kkh.mynews.data.item.news.adapter.NewsItemsAdapter
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.refer.adapter.ReferItemsAdapter
import com.kkh.mynews.data.item.refer.model.ReferItemsModel
import com.kkh.mynews.data.item.shopping.adapter.ShoppingItemsAdapter
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.data.item.web.adapter.WebItemsAdapter
import com.kkh.mynews.data.item.web.model.WebItemsModel
import com.kkh.mynews.data.viewmodel.ContentsViewModel
import com.kkh.mynews.databinding.ActivityDetailBinding
import com.kkh.mynews.view.Presenter
import com.kkh.mynews.view.fragment.MainFragment

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var mContentsViewModel: ContentsViewModel
    private lateinit var mRequestManager: RequestManager

    companion object {
        const val TAG = Constant.TAG_PREFIX + "DetailActivity"
        const val RESULT_COUNT = 50;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContentsViewModel = ViewModelProvider(this).get(ContentsViewModel::class.java)
        mRequestManager = Glide.with(this)
        binding.rview.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        binding.rview.itemAnimator = DefaultItemAnimator()
        binding.rview.setHasFixedSize(true)
        val intent = intent
        val query = intent.getStringExtra(EXTRA_QUERY)
        val viewType = intent.getIntExtra(Constant.EXTRA_VIEW_TYPE, 0)

        binding.rview.layoutManager = LinearLayoutManager(applicationContext)
        binding.rview.itemAnimator = DefaultItemAnimator()
        binding.rview.setHasFixedSize(true)

        when (viewType) {
            Presenter.VIEW_TYPE_NEWS -> {
                mContentsViewModel.newsItemsPaged.observe(this, Observer {
                    val list: List<NewsItemsModel> = it
                    Log.d(TAG, "observed news list size ${list.size} $list")
                    if (list.isNotEmpty()) {
                        val adapter = NewsItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestNews(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_SHOPPING -> {
                mContentsViewModel.shoppingItemsPaged.observe(this, Observer {
                    val list: List<ShoppingItemsModel> = it
                    Log.d(TAG, "observed shopping list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = ShoppingItemsAdapter(mRequestManager)
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestShopping(query!!, RESULT_COUNT)


            }
            Presenter.VIEW_TYPE_BLOG -> {
                mContentsViewModel.blogItemsPaged.observe(this, Observer {
                    val list: List<BlogItemsModel> = it
                    Log.d(TAG, "observed blog list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = BlogItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestBlog(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_BOOK -> {
                mContentsViewModel.bookItemsPaged.observe(this, Observer {
                    val list: List<BookItemsModel> = it
                    Log.d(TAG, "observed book list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = BookItemsAdapter(mRequestManager)
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestBook(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_IMAGE -> {
                mContentsViewModel.imageItemsPaged.observe(this, Observer {
                    val list: List<ImageItemsModel> = it
                    Log.d(TAG, "observed image list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = ImageItemsAdapter(mRequestManager)
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestImage(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_MOVIE -> {
                mContentsViewModel.movieItemsPaged.observe(this, Observer {
                    val list: List<MovieItemsModel> = it
                    Log.d(TAG, "observed movie list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = MovieItemsAdapter(mRequestManager)
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestMovie(query!!, RESULT_COUNT)
            }
            Presenter.VIEW_TYPE_DICT -> {
                mContentsViewModel.dictItemsPaged.observe(this, Observer {
                    val list: List<DictItemsModel> = it
                    Log.d(TAG, "observed dict list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = DictItemsAdapter(mRequestManager)
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestDict(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_CAFE -> {
                mContentsViewModel.cafeItemsPaged.observe(this, Observer {
                    val list: List<CafeItemsModel> = it
                    Log.d(TAG, "observed cafe list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = CafeItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestCafe(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_KNOW -> {
                mContentsViewModel.knowItemsPaged.observe(this, Observer {
                    val list: List<KnowItemsModel> = it
                    Log.d(TAG, "observed know list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = KnowItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestKnow(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_LOCATION -> {
                mContentsViewModel.localItemsPaged.observe(this, Observer {
                    val list: List<LocationItemsModel> = it
                    Log.d(TAG, "observed local list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = LocalItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestLocal(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_WEB -> {
                mContentsViewModel.webItemsPaged.observe(this, Observer {
                    val list: List<WebItemsModel> = it
                    Log.d(TAG, "observed web list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = WebItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestWeb(query!!, RESULT_COUNT)

            }
            Presenter.VIEW_TYPE_REFER -> {
                mContentsViewModel.referItemsPaged.observe(this, Observer {
                    val list: List<ReferItemsModel> = it
                    Log.d(TAG, "observed refer list size ${list.size}")
                    if (list.isNotEmpty()) {
                        val adapter = ReferItemsAdapter()
                        adapter.setList(list)
                        binding.rview.adapter = adapter
                    }
                })
                mContentsViewModel.requestRefer(query!!, RESULT_COUNT)

            }
        }

        binding.refreshLayout.setOnRefreshListener {
            when (viewType) {
                Presenter.VIEW_TYPE_NEWS -> mContentsViewModel.requestNews(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_SHOPPING -> mContentsViewModel.requestShopping(
                    query!!,
                    RESULT_COUNT
                )
                Presenter.VIEW_TYPE_BLOG -> mContentsViewModel.requestBlog(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_BOOK -> mContentsViewModel.requestBook(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_IMAGE -> mContentsViewModel.requestImage(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_MOVIE -> mContentsViewModel.requestMovie(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_DICT -> mContentsViewModel.requestDict(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_CAFE -> mContentsViewModel.requestCafe(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_KNOW -> mContentsViewModel.requestKnow(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_LOCATION -> mContentsViewModel.requestLocal(
                    query!!,
                    RESULT_COUNT
                )
                Presenter.VIEW_TYPE_WEB -> mContentsViewModel.requestWeb(query!!, RESULT_COUNT)
                Presenter.VIEW_TYPE_REFER -> mContentsViewModel.requestRefer(query!!, RESULT_COUNT)
            }
            binding.refreshLayout.isRefreshing = false
        }
    }
}