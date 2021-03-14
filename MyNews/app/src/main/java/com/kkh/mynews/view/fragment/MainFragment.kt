package com.kkh.mynews.view.fragment

import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
import com.kkh.mynews.view.`interface`.IContentsEvent
import com.kkh.mynews.data.item.contents.adapter.ContentsAdapter
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.data.item.keyword.adapter.KeywordRecyclerViewAdapter
import com.kkh.mynews.data.viewmodel.ContentsViewModel
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.know.model.KnowItemsModel
import com.kkh.mynews.data.item.location.model.LocationItemsModel
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.data.item.refer.model.ReferItemsModel
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
    private lateinit var binding: FragmentMainBinding

    private val mContentsList = ArrayList<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        mContentsViewModel = ViewModelProvider(this).get(ContentsViewModel::class.java)
        initKeywordList()
    }

    private fun initKeywordList() {
        val list = ArrayList<KeywordModel>()
        list.add(KeywordModel(0, "뉴스"))
        list.add(KeywordModel(1, "쇼핑"))
        list.add(KeywordModel(2, "블로그"))
        list.add(KeywordModel(3, "책"))
        list.add(KeywordModel(4, "이미지"))
        list.add(KeywordModel(5, "영화"))
        list.add(KeywordModel(6, "백과사전"))
        list.add(KeywordModel(7, "카페글"))
        list.add(KeywordModel(8, "지식in"))
        list.add(KeywordModel(9, "지역"))
        list.add(KeywordModel(10, "웹문서"))
        list.add(KeywordModel(11, "전문자료"))
        mContentsViewModel.insertKeywordList(list)

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
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_NEWS,
                        VIEW_TYPE_NEWS,
                        list[0].query,
                        list
                    )
                )
            }
            updateContentsList()
        })

        mContentsViewModel.shoppingItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ShoppingItemsModel> = it
            Log.d(TAG, "observed shopping list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_SHOPPING,
                        VIEW_TYPE_SHOPPING,
                        list[0].query,
                        list
                    )
                )
            }
            updateContentsList()
        })

        mContentsViewModel.blogItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<BlogItemsModel> = it
            Log.d(TAG, "observed blog list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_BLOG,
                        VIEW_TYPE_BLOG,
                        list[0].query,
                        list
                    )
                )
            }
            updateContentsList()
        })
        mContentsViewModel.bookItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<BookItemsModel> = it
            Log.d(TAG, "observed book list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_BOOK,
                        VIEW_TYPE_BOOK,
                        list[0].query,
                        list
                    )
                )
            }
            updateContentsList()
        })
        mContentsViewModel.imageItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ImageItemsModel> = it
            Log.d(TAG, "observed image list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsList.add(
                    ContentsModel(
                        VIEW_TYPE_IMAGE,
                        VIEW_TYPE_IMAGE,
                        list[0].query,
                        list
                    )
                )
            }
            updateContentsList()
        })

        mContentsViewModel.movieItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<MovieItemsModel> = it
            Log.d(TAG, "observed movie list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
        mContentsViewModel.dictItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<DictItemsModel> = it
            Log.d(TAG, "observed dict list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
        mContentsViewModel.cafeItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<CafeItemsModel> = it
            Log.d(TAG, "observed cafe list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
        mContentsViewModel.knowItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<KnowItemsModel> = it
            Log.d(TAG, "observed know list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
        mContentsViewModel.localItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<LocationItemsModel> = it
            Log.d(TAG, "observed local list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
        mContentsViewModel.webItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<WebItemsModel> = it
            Log.d(TAG, "observed web list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
        mContentsViewModel.referItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ReferItemsModel> = it
            Log.d(TAG, "observed refer list size ${list.size}")
            if (list.isNotEmpty()) {
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
            }
            updateContentsList()
        })
    }

    private val mIContentsEvent = object : IContentsEvent {
        override fun onBindItem(data: ContentsModel) {
            mKeywordAdapter.selectPosition(data.viewType)
        }
    }

    private fun initViews() {
        binding.add.visibility = View.GONE
        binding.progress.root.visibility = View.GONE
        // contents(total)
        mContentsAdapter =
            ContentsAdapter()
        mContentsAdapter.setList(mContentsList)
        mContentsAdapter.setEvent(mIContentsEvent)
        binding.recyclerView.adapter = mContentsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.setHasFixedSize(true)

        // keyword
        mKeywordAdapter =
            KeywordRecyclerViewAdapter(
                mContentsViewModel
            )
        binding.keywordListView.adapter = mKeywordAdapter
        binding.keywordListView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.keywordListView.itemAnimator = DefaultItemAnimator()


        binding.searchBtn.setOnClickListener {
            mContentsList.clear()
            var query = binding.searchView.query.toString()
            binding.progress.root.visibility = View.VISIBLE
            mContentsViewModel.request(query)
        }

        binding.clearBtn.setOnClickListener {
            binding.searchView.setQuery("", false)
        }

        binding.reset.setOnClickListener {
            mContentsList.clear()
            mContentsAdapter.setList(mContentsList);
        }
//        MyWorkerManager.workRequest()
//        MyWorkerManager.workRequestMutiTime()

    }

    private fun updateContentsList() {
        synchronized(lock = this) {
            mContentsAdapter.setList(mContentsList)
            if (mContentsList.size == REQUEST_COUNT) {
                binding.progress.root.visibility = View.GONE
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