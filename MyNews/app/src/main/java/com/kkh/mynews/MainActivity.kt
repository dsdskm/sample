package com.kkh.mynews

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.*
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kkh.mynews.common.Constant
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.test.dagger2.DaggerActivity
import com.kkh.mynews.view.adapter.KeywordRecyclerViewAdapter
import com.kkh.mynews.viewmodel.NewsViewModel
import com.kkh.mynews.view.adapter.NewsItemsAdapter
import com.kkh.mynews.workmanager.MyWorkerManager

/*

    MainActivity / Fragment - NewsViewModel
    NewsViewModel(LiveData) - NewsRepository
    NewsRepository - Model(Room)
    NewsRepository - Remote Data Source(Retrofit)
    https://developer.android.com/guide/?hl=ko
 */


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "MainActivity"
    }

    private val mNewsViewModel: NewsViewModel by viewModels()

    val mSearchView by lazy { findViewById<SearchView>(R.id.searchView) }
    val mSearchBtn by lazy { findViewById<Button>(R.id.searchBtn) }
    val mClearBtn by lazy { findViewById<Button>(R.id.clearBtn) }
    val mAddBtn by lazy { findViewById<Button>(R.id.add) }
    val mKeywordRecyclerView by lazy { findViewById<RecyclerView>(R.id.keywordListView) }
    val mRecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    val mPagedAdapter = NewsItemsAdapter()
    private lateinit var mKeywordAdapter: KeywordRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initView()
    }

    private fun initView() {
        mKeywordAdapter = KeywordRecyclerViewAdapter(mNewsViewModel)
        mKeywordRecyclerView.adapter = mKeywordAdapter
        mKeywordRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mKeywordRecyclerView.itemAnimator = DefaultItemAnimator()

        mRecyclerView.adapter = mPagedAdapter
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)

        mNewsViewModel.keyword.observe(this, Observer {
            val list: List<KeywordModel> = it
            Log.d(TAG, "observed keyword list size ${list.size}")
            mKeywordAdapter.setList(list)
        })

        mNewsViewModel.newsItemsPaged.observe(this, Observer {
            val list: List<NewsItemsModel> = it
            Log.d(TAG, "observed list size ${list.size}")
            mPagedAdapter.setList(list)
        })
        mSearchBtn.setOnClickListener {
            mNewsViewModel.requestNews(mSearchView.query.toString())
        }

        mClearBtn.setOnClickListener {

        }

        mAddBtn.setOnClickListener {
            showDialog()
        }
        MyWorkerManager.workRequest()
        MyWorkerManager.workRequestMutiTime()
        startActivity(Intent(this, DaggerActivity::class.java))
    }

    private fun showDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
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