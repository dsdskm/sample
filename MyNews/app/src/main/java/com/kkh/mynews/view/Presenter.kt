package com.kkh.mynews.view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.kkh.mynews.DetailActivity
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Constant.Companion.EXTRA_QUERY
import com.kkh.mynews.common.Constant.Companion.EXTRA_VIEW_TYPE
import com.kkh.mynews.data.item.blog.adapter.BlogItemsAdapter
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.adapter.BookItemsAdapter
import com.kkh.mynews.data.item.book.adapter.ImageItemsAdapter
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.cafe.adapter.CafeItemsAdapter
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
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
import com.kkh.mynews.databinding.ListContentsItemLayoutBinding

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
    fun update(data: ContentsModel, v: ListContentsItemLayoutBinding) {
        v.rview.layoutManager =
            LinearLayoutManager(v.root.context, LinearLayoutManager.HORIZONTAL, false)
        v.rview.itemAnimator = DefaultItemAnimator()
        v.rview.setHasFixedSize(true)
        var title = ""
        when (data.viewType) {
            VIEW_TYPE_NEWS -> {
                updateNewsPresenter(v.rview, data.list)
                title = "뉴스"
            }
            VIEW_TYPE_SHOPPING -> {
                updateShoppingPresenter(v.rview, data.list)
                title = "쇼핑"
            }
            VIEW_TYPE_BLOG -> {
                updateBlogPresenter(v.rview, data.list)
                title = "블로그"
            }
            VIEW_TYPE_BOOK -> {
                updateBookPresenter(v.rview, data.list)
                title = "책"
            }
            VIEW_TYPE_IMAGE -> {
                updateImagePresenter(v.rview, data.list)
                title = "이미지"
            }
            VIEW_TYPE_MOVIE -> {
                updateMoviePresenter(v.rview, data.list)
                title = "영화"
            }
            VIEW_TYPE_DICT -> {
                updateDictPresenter(v.rview, data.list)
                title = "백과사전"
            }
            VIEW_TYPE_CAFE -> {
                updateCafePresenter(v.rview, data.list)
                title = "카페글"
            }
            VIEW_TYPE_KNOW -> {
                updateKnowPresenter(v.rview, data.list)
                title = "지식in"
            }
            VIEW_TYPE_LOCATION -> {
                updateLocalPresenter(v.rview, data.list)
                title = "지역"
            }
            VIEW_TYPE_WEB -> {
                updateWebPresenter(v.rview, data.list)
                title = "웹"
            }
            VIEW_TYPE_REFER -> {
                updateReferPresenter(v.rview, data.list)
                title = "전문자료"
            }
        }
        v.title.text = title
        v.more.setOnClickListener {
            val intent = Intent(v.root.context, DetailActivity::class.java)
            intent.putExtra(EXTRA_VIEW_TYPE, data.viewType)
            intent.putExtra(EXTRA_QUERY, data.query)
            v.root.context.startActivity(intent)
        }

    }

    private fun updateNewsPresenter(rview: RecyclerView, l: List<Any>) {
        val list: ArrayList<NewsItemsModel> = ArrayList()

        for (element in l) {
            try {
                element.let {
                    Log.d(TAG,"it $it")
                    if(it!=null) {
                        list.add(it as NewsItemsModel)
                    }
                }
            } catch (e: TypeCastException) {
                continue
                e.printStackTrace()

            }

        }

        val adapter = NewsItemsAdapter()
        adapter.setList(list)
        rview.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun updateShoppingPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateBlogPresenter(rview: RecyclerView, l: List<Any>) {
        val list: ArrayList<BlogItemsModel> = ArrayList()
        try {
            for (element in l) {
                list.add(element as BlogItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = BlogItemsAdapter()
        adapter.setList(list)
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateBookPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateImagePresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateMoviePresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateDictPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateCafePresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateKnowPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateLocalPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateWebPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun updateReferPresenter(rview: RecyclerView, l: List<Any>) {
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
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}