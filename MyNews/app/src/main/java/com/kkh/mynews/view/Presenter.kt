package com.kkh.mynews.view

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.kkh.mynews.common.Constant
import com.kkh.mynews.data.item.blog.adapter.BlogItemsAdapter
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.adapter.BookItemsAdapter
import com.kkh.mynews.data.item.book.adapter.ImageItemsAdapter
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.contents.adapter.ContentsAdapter
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.news.adapter.NewsItemsAdapter
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.shopping.adapter.ShoppingItemsAdapter
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel

class Presenter(context: Context) {
    companion object{
        const val TAG = Constant.TAG_PREFIX + "Presenter"
        const val VIEW_TYPE_NEWS = 0
        const val VIEW_TYPE_SHOPPING = 1
        const val VIEW_TYPE_BLOG = 2
        const val VIEW_TYPE_BOOK = 3
        const val VIEW_TYPE_IMAGE = 4
        const val VIEW_TYPE_MOVIE = 5
    }
    private val mRequestManager: RequestManager = Glide.with(context)
    fun update(data: ContentsModel, holder: ContentsAdapter.ViewHolder) {
        holder.mRecyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.mRecyclerView.itemAnimator = DefaultItemAnimator()
        holder.mRecyclerView.setHasFixedSize(true)
        when (data.viewType) {
            VIEW_TYPE_NEWS -> updateNewsPresenter(data.list, holder)
            VIEW_TYPE_SHOPPING -> updateShoppingPresenter(data.list, holder)
            VIEW_TYPE_BLOG -> updateBlogPresenter(data.list, holder)
            VIEW_TYPE_BOOK -> updateBookPresenter(data.list, holder)
            VIEW_TYPE_IMAGE -> updateImagePresenter(data.list, holder)
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
        val adapter =
            ShoppingItemsAdapter(
                mRequestManager
            )
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
    private fun updateBookPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG,"updateBookPresenter")
        val list: ArrayList<BookItemsModel> = ArrayList()
        for (element in l) {
            list.add(element as BookItemsModel)
        }
        val adapter = BookItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Book"
    }
    private fun updateImagePresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG,"updateImagePresenter")
        val list: ArrayList<ImageItemsModel> = ArrayList()
        for (element in l) {
            list.add(element as ImageItemsModel)
        }
        val adapter = ImageItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Image"
    }
}