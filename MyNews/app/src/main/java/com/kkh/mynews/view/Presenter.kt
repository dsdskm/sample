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
import com.kkh.mynews.data.item.cafe.adapter.CafeItemsAdapter
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
import com.kkh.mynews.data.item.contents.adapter.ContentsAdapter
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.data.item.image.model.ImageItemsModel
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

class Presenter(context: Context) {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "Presenter"
        const val VIEW_TYPE_NEWS = 0
        const val VIEW_TYPE_SHOPPING = 1
        const val VIEW_TYPE_BLOG = 2
        const val VIEW_TYPE_BOOK = 3
        const val VIEW_TYPE_IMAGE = 4
        const val VIEW_TYPE_MOVIE = 5
        const val VIEW_TYPE_DICT = 6
        const val VIEW_TYPE_CAFE = 7
        const val VIEW_TYPE_KNOW = 8
        const val VIEW_TYPE_LOCATION = 9
        const val VIEW_TYPE_WEB = 10
        const val VIEW_TYPE_REFER = 11
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
            VIEW_TYPE_MOVIE -> updateMoviePresenter(data.list, holder)
            VIEW_TYPE_DICT -> updateDictPresenter(data.list, holder)
            VIEW_TYPE_CAFE -> updateCafePresenter(data.list, holder)
            VIEW_TYPE_KNOW -> updateKnowPresenter(data.list, holder)
            VIEW_TYPE_LOCATION -> updateLocalPresenter(data.list, holder)
            VIEW_TYPE_WEB -> updateWebPresenter(data.list, holder)
            VIEW_TYPE_REFER -> updateReferPresenter(data.list, holder)
        }

    }

    private fun updateNewsPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val list: ArrayList<NewsItemsModel> = ArrayList()
        try {
            for (element in l) {
                element.let {
                    list.add(it as NewsItemsModel)
                }

            }
        } catch (e: TypeCastException) {

        }

        val adapter = NewsItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "News"

    }

    private fun updateShoppingPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val list: ArrayList<ShoppingItemsModel> = ArrayList()
        try {
            for (element in l) {
                element.let {
                    list.add(it as ShoppingItemsModel)
                }

            }
        } catch (e: TypeCastException) {

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
        try {
            for (element in l) {
                list.add(element as BlogItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = BlogItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Blog"
    }

    private fun updateBookPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateBookPresenter")
        val list: ArrayList<BookItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as BookItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = BookItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Book"
    }

    private fun updateImagePresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateImagePresenter")
        val list: ArrayList<ImageItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as ImageItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = ImageItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Image"
    }

    private fun updateMoviePresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateMoviePresenter")
        val list: ArrayList<MovieItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as MovieItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = MovieItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Movie"
    }

    private fun updateDictPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateDictPresenter")
        val list: ArrayList<DictItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as DictItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = DictItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Dict"
    }

    private fun updateCafePresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateCafePresenter")
        val list: ArrayList<CafeItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as CafeItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = CafeItemsAdapter(
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Cafe"
    }

    private fun updateKnowPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateKnowPresenter")
        val list: ArrayList<KnowItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as KnowItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = KnowItemsAdapter(
        )
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Know"
    }

    private fun updateLocalPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateLocalPresenter")
        val list: ArrayList<LocationItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as LocationItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = LocalItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Local"
    }

    private fun updateWebPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateWebPresenter")
        val list: ArrayList<WebItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as WebItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = WebItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Web"
    }

    private fun updateReferPresenter(l: List<Any>, holder: ContentsAdapter.ViewHolder) {
        Log.d(TAG, "updateReferPresenter")
        val list: ArrayList<ReferItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as ReferItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = ReferItemsAdapter()
        adapter.setList(list)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Reference"
    }
}