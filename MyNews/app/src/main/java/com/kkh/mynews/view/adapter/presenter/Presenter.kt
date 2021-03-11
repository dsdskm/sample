package com.kkh.mynews.view.adapter.presenter

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.view.adapter.BlogItemsAdapter
import com.kkh.mynews.view.adapter.ContentsAdapter
import com.kkh.mynews.view.adapter.NewsItemsAdapter
import com.kkh.mynews.view.adapter.ShoppingItemsAdapter

class Presenter {

    fun update(data: ContentsModel, holder: ContentsAdapter.ViewHolder) {
        holder.mRecyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.mRecyclerView.itemAnimator = DefaultItemAnimator()
        holder.mRecyclerView.setHasFixedSize(true)
        when (data.viewType) {
            ContentsAdapter.VIEW_TYPE_NEWS -> updateNewsPresenter(data.list, holder)
            ContentsAdapter.VIEW_TYPE_SHOPPING -> updateShoppingPresenter(data.list, holder)
            ContentsAdapter.VIEW_TYPE_BLOG -> updateBlogPresenter(data.list, holder)
        }
    }

    private fun updateNewsPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val list: ArrayList<NewsItemsModel> = ArrayList()
        for (element in l) {
            list.add(element as NewsItemsModel)
        }
        val adapter = NewsItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "News"

    }

    private fun updateShoppingPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val list: ArrayList<ShoppingItemsModel> = ArrayList()
        for (element in l) {
            list.add(element as ShoppingItemsModel)
        }
        val adapter = ShoppingItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Shopping"
    }

    private fun updateBlogPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val list: ArrayList<BlogItemsModel> = ArrayList()
        for (element in l) {
            list.add(element as BlogItemsModel)
        }
        val adapter = BlogItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Blog"
    }
}