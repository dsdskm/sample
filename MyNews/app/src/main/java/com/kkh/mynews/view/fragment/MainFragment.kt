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
import com.kkh.mynews.item.contents.ContentsModel
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.view.`interface`.IContentsEvent
import com.kkh.mynews.view.adapter.ContentsAdapter
import com.kkh.mynews.view.adapter.ContentsAdapter.Companion.VIEW_TYPE_NEWS
import com.kkh.mynews.view.adapter.ContentsAdapter.Companion.VIEW_TYPE_SHOPPING
import com.kkh.mynews.view.adapter.KeywordRecyclerViewAdapter
import com.kkh.mynews.view.adapter.NewsItemsAdapter
import com.kkh.mynews.view.adapter.ShoppingItemsAdapter
import com.kkh.mynews.viewmodel.NewsViewModel

class MainFragment : ContentsFragment() {

    companion object {
        const val TAG = Constant.TAG_PREFIX + "MainFragment"
        fun newInstance() = MainFragment()
    }

    private lateinit var mNewsViewModel: NewsViewModel
    private lateinit var mSearchView: SearchView
    private lateinit var mSearchBtn: Button
    private lateinit var mClearBtn: Button
    private lateinit var mAddBtn: Button
    private lateinit var mResetBtn: Button

    private lateinit var mKeywordRecyclerView: RecyclerView
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mShoppingRecyclerView: RecyclerView

    private lateinit var mContentsAdapter: ContentsAdapter
    private lateinit var mNewsAdapter: NewsItemsAdapter
    private lateinit var mKeywordAdapter: KeywordRecyclerViewAdapter
    private lateinit var mShoppingAdapter: ShoppingItemsAdapter

    private val mContentsList = ArrayList<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        mNewsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView");
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initViews(view)
        return view
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
        mResetBtn = view.findViewById(R.id.reset)
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
        mKeywordAdapter = KeywordRecyclerViewAdapter(mNewsViewModel)
        mKeywordRecyclerView.adapter = mKeywordAdapter
        mKeywordRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mKeywordRecyclerView.itemAnimator = DefaultItemAnimator()
        mNewsViewModel.keyword.observe(viewLifecycleOwner, Observer {
            val list: List<KeywordModel> = it
            Log.d(MainActivity.TAG, "observed keyword list size ${list.size}")
            mKeywordAdapter.setList(list)

        })

        mNewsViewModel.newsItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<NewsItemsModel> = it
            Log.d(MainActivity.TAG, "observed news list size ${list.size}")
            //mNewsAdapter.setList(list)
            if (list.isNotEmpty()) {
                mContentsList.add(ContentsModel(0, VIEW_TYPE_NEWS, list[0].query, list))
            }
            mContentsAdapter.setList(mContentsList)
        })

        mNewsViewModel.shoppingItemsPaged.observe(viewLifecycleOwner, Observer {
            val list: List<ShoppingItemsModel> = it
            Log.d(MainActivity.TAG, "observed list size ${list.size}")
            if (list.isNotEmpty()) {
                mContentsList.add(ContentsModel(0, VIEW_TYPE_SHOPPING, list[0].query, list))
            }
            mContentsAdapter.setList(mContentsList)

        })
        mSearchBtn.setOnClickListener {
            mContentsList.clear()
            val query = mSearchView.query.toString()
            mNewsViewModel.requestShopping(query)
            //mNewsViewModel.requestNews(query)
        }

        mClearBtn.setOnClickListener {

        }

        mAddBtn.setOnClickListener {
            showDialog()
        }

        mResetBtn.setOnClickListener {
            mContentsList.clear()
            mNewsViewModel.deleteNewsAll()
        }
//        MyWorkerManager.workRequest()
//        MyWorkerManager.workRequestMutiTime()

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

            mNewsViewModel.insertKeywordList(
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