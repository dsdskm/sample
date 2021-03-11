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
import com.kkh.mynews.MainActivity
import com.kkh.mynews.MyNewsApplication
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.view.`interface`.IContentsEvent
import com.kkh.mynews.view.adapter.ContentsAdapter
import com.kkh.mynews.view.adapter.ContentsAdapter.Companion.VIEW_TYPE_NEWS
import com.kkh.mynews.view.adapter.ContentsAdapter.Companion.VIEW_TYPE_SHOPPING
import com.kkh.mynews.view.adapter.KeywordRecyclerViewAdapter
import com.kkh.mynews.data.viewmodel.ContentsViewModel
import com.kkh.mynews.view.adapter.ContentsAdapter.Companion.VIEW_TYPE_BLOG

class MainFragment : ContentsFragment() {

    companion object {
        const val TAG = Constant.TAG_PREFIX + "MainFragment"
        fun newInstance() = MainFragment()
        var REQUEST_COUNT = 0
    }

    private lateinit var mContentsViewModel: ContentsViewModel
    private lateinit var mSearchView: SearchView
    private lateinit var mSearchBtn: Button
    private lateinit var mClearBtn: Button
    private lateinit var mAddBtn: Button
    private lateinit var mResetBtn: Button
    private lateinit var mProgressDialog: View

    private lateinit var mKeywordRecyclerView: RecyclerView
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mContentsAdapter: ContentsAdapter
    private lateinit var mKeywordAdapter: KeywordRecyclerViewAdapter

    private val mContentsList = ArrayList<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        mContentsViewModel = ViewModelProvider(this).get(ContentsViewModel::class.java)
        initKeywordList()
    }

    private fun initKeywordList() {
        val list = ArrayList<KeywordModel>()
        list.add(KeywordModel("뉴스"))
        list.add(KeywordModel("쇼핑"))
        list.add(KeywordModel("블로그"))
        list.add(KeywordModel("이미지"))
        list.add(KeywordModel("책"))
        list.add(KeywordModel("백과사전"))
        list.add(KeywordModel("영화"))
        list.add(KeywordModel("카페글"))
        list.add(KeywordModel("지식in"))
        list.add(KeywordModel("지역"))
        list.add(KeywordModel("오타변환"))
        list.add(KeywordModel("웹문서"))
        list.add(KeywordModel("전문자료"))
        mContentsViewModel.insertKeywordList(list)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView");
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initViews(view)
        initViewModel()
        return view
    }

    private fun initViewModel() {
        mContentsViewModel.keyword.observe(viewLifecycleOwner, Observer {
            val list: List<KeywordModel> = it
            Log.d(MainActivity.TAG, "observed keyword list size ${list.size}")
            mKeywordAdapter.setList(list)

        })

        mContentsViewModel.newsItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<NewsItemsModel> = it
            Log.d(MainActivity.TAG, "observed news list size ${list.size}")
            //mNewsAdapter.setList(list)
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
            Log.d(MainActivity.TAG, "observed shopping list size ${list.size}")
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
            Log.d(MainActivity.TAG, "observed blog list size ${list.size}")
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


    }

    private val mIContentsEvent = object : IContentsEvent {
        override fun onBindItem(data: ContentsModel) {
            mKeywordAdapter.selectPosition(data.query)
        }
    }

    private fun initViews(view: View) {
        mSearchView = view.findViewById(R.id.searchView)
        mSearchBtn = view.findViewById(R.id.searchBtn)
        mClearBtn = view.findViewById(R.id.clearBtn)
        mAddBtn = view.findViewById(R.id.add)
        mAddBtn.visibility = View.GONE
        mResetBtn = view.findViewById(R.id.reset)
        mProgressDialog = view.findViewById<View>(R.id.progress)
        if (REQUEST_COUNT == 0) {
            mProgressDialog.visibility = View.GONE
        }
        mKeywordRecyclerView = view.findViewById(R.id.keywordListView)
        mRecyclerView = view.findViewById(R.id.recyclerView)
        //mShoppingRecyclerView = view.findViewById(R.id.recyclerView)

        // contents(total)
        mContentsAdapter = ContentsAdapter()
        mContentsAdapter.setList(mContentsList)
        mContentsAdapter.setEvent(mIContentsEvent)
        mRecyclerView.adapter = mContentsAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        mRecyclerView.setHasFixedSize(true)

        // keyword
        mKeywordAdapter = KeywordRecyclerViewAdapter(mContentsViewModel)
        mKeywordRecyclerView.adapter = mKeywordAdapter
        mKeywordRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mKeywordRecyclerView.itemAnimator = DefaultItemAnimator()


        mSearchBtn.setOnClickListener {
            mContentsList.clear()
            val query = mSearchView.query.toString()
            mProgressDialog.visibility = View.VISIBLE
            mContentsViewModel.requestShopping(query)
            mContentsViewModel.requestNews(query)
            mContentsViewModel.requestBlog(query)
            REQUEST_COUNT = 3

        }

        mClearBtn.setOnClickListener {

        }

        mAddBtn.setOnClickListener {
            showDialog()
        }

        mResetBtn.setOnClickListener {
            mContentsList.clear()
            mContentsViewModel.deleteAll()
        }
//        MyWorkerManager.workRequest()
//        MyWorkerManager.workRequestMutiTime()

    }

    private fun updateContentsList() {
        synchronized(lock = this) {
            mContentsAdapter.setList(mContentsList)
            if (mContentsList.size == REQUEST_COUNT) {
                mProgressDialog.visibility = View.GONE
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

            mContentsViewModel.insertKeywordList(
                KeywordModel(
                    input.text.toString(),
                    System.currentTimeMillis()
                )
            )
            dialog.dismiss()
        }
        builder.setNegativeButton(android.R.string.cancel) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        builder.show()
    }
}