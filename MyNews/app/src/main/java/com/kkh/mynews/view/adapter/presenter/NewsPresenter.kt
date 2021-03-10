package com.kkh.mynews.view.adapter.presenter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.view.adapter.ContentsAdapter
import com.kkh.mynews.view.adapter.NewsItemsAdapter

class NewsPresenter {
    fun update(list: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val newsList: ArrayList<NewsItemsModel> = ArrayList()
        for (element in list) {
            newsList.add(element as NewsItemsModel)
        }
        val adapter = NewsItemsAdapter()
        adapter.setList(newsList)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "News"

    }
}