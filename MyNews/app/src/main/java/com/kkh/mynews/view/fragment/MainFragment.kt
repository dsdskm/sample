package com.kkh.mynews.view.fragment

import android.content.DialogInterface
import android.database.Cursor
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kkh.mynews.MyNewsApplication
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.data.item.contents.adapter.ContentsAdapter
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.data.item.keyword.adapter.KeywordRecyclerViewAdapter
import com.kkh.mynews.data.viewmodel.ContentsViewModel
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.keyword.adapter.IKeywordItemEvent
import com.kkh.mynews.data.item.know.model.KnowItemsModel
import com.kkh.mynews.data.item.location.model.LocationItemsModel
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.data.item.refer.model.ReferItemsModel
import com.kkh.mynews.data.item.search.model.SearchModel
import com.kkh.mynews.data.item.web.model.WebItemsModel
import com.kkh.mynews.databinding.FragmentMainBinding
import com.kkh.mynews.databinding.ListBookItemLayoutBinding
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_BLOG
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_BOOK
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_CAFE
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_DICT
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_IMAGE
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_KNOW
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_LOCATION
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_MOVIE
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_NEWS
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_REFER
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_SHOPPING
import com.kkh.mynews.view.Presenter.Companion.VIEW_TYPE_WEB

class MainFragment : ContentsFragment() {

    companion object {
        const val TAG = Constant.TAG_PREFIX + "MainFragment"
        fun newInstance() = MainFragment()
        var REQUEST_COUNT = 12
    }

    private lateinit var mContentsViewModel: ContentsViewModel
    private lateinit var mContentsAdapter: ContentsAdapter
    private lateinit var mKeywordAdapter: KeywordRecyclerViewAdapter
    private val mContentLayoutManager:LinearLayoutManager = LinearLayoutManager(context)
    private lateinit var binding: FragmentMainBinding

    private val mContentsList = ArrayList<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        mContentsViewModel = ViewModelProvider(this).get(ContentsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView");
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(container!!.context), container, false)

        initViews()
        initViewModel()
        binding.searchView.setQuery("손흥민", false)
        return binding.root
    }

    private fun initViewModel() {
        mContentsViewModel.keyword.observe(viewLifecycleOwner, Observer {
            val list: List<KeywordModel> = it
            Log.d(TAG, "observed keyword list size ${list.size}")
            mKeywordAdapter.setList(list)

        })

        mContentsViewModel.newsItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<NewsItemsModel> = it
            Log.d(TAG, "observed news list size ${list}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(0, "뉴스"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_NEWS,
                        VIEW_TYPE_NEWS,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("뉴스");
            }
            updateContentsList()
        })

        mContentsViewModel.shoppingItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ShoppingItemsModel> = it
            Log.d(TAG, "observed shopping list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(1, "쇼핑"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_SHOPPING,
                        VIEW_TYPE_SHOPPING,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("쇼핑");
            }
            updateContentsList()
        })

        mContentsViewModel.blogItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<BlogItemsModel> = it
            Log.d(TAG, "observed blog list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(2, "블로그"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_BLOG,
                        VIEW_TYPE_BLOG,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("블로그")
            }
            updateContentsList()
        })
        mContentsViewModel.bookItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<BookItemsModel> = it
            Log.d(TAG, "observed book list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(3, "책"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_BOOK,
                        VIEW_TYPE_BOOK,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("책")
            }
            updateContentsList()
        })
        mContentsViewModel.imageItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ImageItemsModel> = it
            Log.d(TAG, "observed image list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(4, "이미지"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_IMAGE,
                        VIEW_TYPE_IMAGE,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("이미지")
            }
            updateContentsList()
        })

        mContentsViewModel.movieItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<MovieItemsModel> = it
            Log.d(TAG, "observed movie list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(5, "영화"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_MOVIE,
                        VIEW_TYPE_MOVIE,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("영화")
            }
            updateContentsList()
        })
        mContentsViewModel.dictItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<DictItemsModel> = it
            Log.d(TAG, "observed dict list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(6, "백과사전"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_DICT,
                        VIEW_TYPE_DICT,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("백과사전")
            }
            updateContentsList()
        })
        mContentsViewModel.cafeItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<CafeItemsModel> = it
            Log.d(TAG, "observed cafe list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(7, "카페글"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_CAFE,
                        VIEW_TYPE_CAFE,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("카페글")
            }
            updateContentsList()
        })
        mContentsViewModel.knowItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<KnowItemsModel> = it
            Log.d(TAG, "observed know list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(8, "지식in"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_KNOW,
                        VIEW_TYPE_KNOW,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("지식in")
            }
            updateContentsList()
        })
        mContentsViewModel.localItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<LocationItemsModel> = it
            Log.d(TAG, "observed local list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(9, "지역"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_LOCATION,
                        VIEW_TYPE_LOCATION,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("지역")
            }
            updateContentsList()
        })
        mContentsViewModel.webItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<WebItemsModel> = it
            Log.d(TAG, "observed web list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(10, "웹문서"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_WEB,
                        VIEW_TYPE_WEB,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("웹문서")
            }
            updateContentsList()
        })
        mContentsViewModel.referItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ReferItemsModel> = it
            Log.d(TAG, "observed refer list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsViewModel.insertKeyword(KeywordModel(11, "전문자료"))
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_REFER,
                        VIEW_TYPE_REFER,
                        list[0].query,
                        list
                    )
                )
            } else {
                REQUEST_COUNT--;
                mContentsViewModel.deleteKeyword("전문자료")
            }
            updateContentsList()
        })


    }

    private val mIKeywordItemEvent: IKeywordItemEvent = object : IKeywordItemEvent {
        override fun onItemClick(pos: Int) {
            Handler(Looper.getMainLooper()).postDelayed({
                Log.d(TAG,"onItemClick pos $pos")
                //binding.recyclerView.smoothScrollToPosition(pos)
                mContentLayoutManager.scrollToPositionWithOffset(pos,0)

            }, 200)
        }
    }

    private var mWordCursor: Cursor? = null
    private fun initViews() {
        binding.add.visibility = View.GONE
        binding.progressView.root.visibility = View.GONE
        // contents(total)
        mContentsAdapter = ContentsAdapter()
        mContentsAdapter.setList(mContentsList)
        binding.recyclerView.adapter = mContentsAdapter
        binding.recyclerView.layoutManager = mContentLayoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val firstCompletelyVisible = mContentLayoutManager.findFirstCompletelyVisibleItemPosition()
                val firstVisible = mContentLayoutManager.findFirstVisibleItemPosition()
                Log.d(
                    TAG,
                    "onScrollStateChanged firstCompletelyVisible $firstCompletelyVisible firstVisible $firstVisible"
                )
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstCompletelyVisible = mContentLayoutManager.findFirstCompletelyVisibleItemPosition()
                val firstVisible = mContentLayoutManager.findFirstVisibleItemPosition()
                Log.d(
                    TAG,
                    "onScrolled dx : $dx dy : $dy firstCompletelyVisible $firstCompletelyVisible firstVisible $firstVisible"
                )
                binding.keywordListView.scrollToPosition(firstVisible)
                mKeywordAdapter.selectPosition(firstVisible)

            }
        })


        // keyword
        mKeywordAdapter = KeywordRecyclerViewAdapter(mContentsViewModel)
        mKeywordAdapter.setEvent(mIKeywordItemEvent)
        binding.keywordListView.adapter = mKeywordAdapter
        binding.keywordListView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.keywordListView.itemAnimator = DefaultItemAnimator()


        binding.searchBtn.setOnClickListener {
            mContentsList.clear()
            var query = binding.searchView.query.toString()
            binding.progressView.root.visibility = View.VISIBLE
            mContentsViewModel.request(query)
        }


        binding.reset.setOnClickListener {
            mContentsList.clear()
            mContentsViewModel.deleteKeywordAll()
            mContentsAdapter.setList(mContentsList);
        }

        Thread {
            //mContentsViewModel.insertSearchWord(SearchModel(0,word="박지성"))
            mWordCursor = mContentsViewModel.getSearchWordList()
            mSearchViewHandler.sendEmptyMessage(0)
            Log.d(TAG,"mWordCursor ${mWordCursor!!.count}")
        }.start()



        binding.searchView.setOnSearchClickListener {
            binding.suggestionView.visibility = View.VISIBLE
        }
        binding.searchView.setOnCloseListener {
            binding.suggestionView.visibility = View.GONE
            true
        }

//        MyWorkerManager.workRequest()
//        MyWorkerManager.workRequestMutiTime()

    }

    private val mSearchViewHandler = object:Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            binding.searchView.suggestionsAdapter = SearchViewAdapter(context,mWordCursor,true)
        }
    }

    private fun updateContentsList() {
        synchronized(lock = this) {
            Log.d(TAG, "updateContentsList list ${mContentsList.size} count $REQUEST_COUNT")
            mContentsAdapter.setList(mContentsList)
            if (mContentsList.size == REQUEST_COUNT) {
                binding.progressView.root.visibility = View.GONE
            }
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated");
    }

    private fun showDialog() {

        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(activity)
        builder.setTitle("키워드 추가")
        val view = LayoutInflater.from(MyNewsApplication.getAppContext())
            .inflate(R.layout.dialog_layout, null)
        val input = view.findViewById<EditText>(R.id.edit)
        builder.setView(view)
        builder.setPositiveButton(android.R.string.ok) { dialog: DialogInterface, _: Int ->
            /*
            mContentsViewModel.insertKeywordList(
                KeywordModel(
                    input.text.toString(),
                    System.currentTimeMillis()
                )
            )

             */
            dialog.dismiss()
        }
        builder.setNegativeButton(android.R.string.cancel) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        builder.show()
    }
}