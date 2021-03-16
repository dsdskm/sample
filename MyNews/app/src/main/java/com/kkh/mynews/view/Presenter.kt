package com.kkh.mynews.view

import android.content.Context
import android.util.Log
import android.view.View
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
    private lateinit var mList:List<Any>
    private lateinit var mView:ListContentsItemLayoutBinding
    fun update(data: ContentsModel, v: ListContentsItemLayoutBinding) {
        mList = data.list
        mView = v
        v.rview.layoutManager =
            LinearLayoutManager(v.root.context, LinearLayoutManager.HORIZONTAL, false)
        v.rview.itemAnimator = DefaultItemAnimator()
        v.rview.setHasFixedSize(true)

        when (data.viewType) {
            VIEW_TYPE_NEWS -> updateNewsPresenter("뉴스")
            VIEW_TYPE_SHOPPING -> updateShoppingPresenter("쇼핑")
            VIEW_TYPE_BLOG -> updateBlogPresenter("블로그")
            VIEW_TYPE_BOOK -> updateBookPresenter("책")
            VIEW_TYPE_IMAGE -> updateImagePresenter("이미지")
            VIEW_TYPE_MOVIE -> updateMoviePresenter("영화")
            VIEW_TYPE_DICT -> updateDictPresenter("백과사전")
            VIEW_TYPE_CAFE -> updateCafePresenter("카페글")
            VIEW_TYPE_KNOW -> updateKnowPresenter("지식in")
            VIEW_TYPE_LOCATION -> updateLocalPresenter("지역")
            VIEW_TYPE_WEB -> updateWebPresenter("웹")
            VIEW_TYPE_REFER -> updateReferPresenter("전문자료")
        }

    }

    private fun updateNewsPresenter(title:String) {
        val list: ArrayList<NewsItemsModel> = ArrayList()
        try {
            for (element in mList) {
                element.let {
                    list.add(it as NewsItemsModel)
                }

            }
        } catch (e: TypeCastException) {

        }

        val adapter = NewsItemsAdapter()
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title

    }

    private fun updateShoppingPresenter(title:String) {
        val list: ArrayList<ShoppingItemsModel> = ArrayList()
        try {
            for (element in mList) {
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
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateBlogPresenter(title:String) {
        val list: ArrayList<BlogItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as BlogItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = BlogItemsAdapter()
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateBookPresenter(title:String) {
        Log.d(TAG, "updateBookPresenter")
        val list: ArrayList<BookItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as BookItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = BookItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateImagePresenter(title:String) {
        Log.d(TAG, "updateImagePresenter")
        val list: ArrayList<ImageItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as ImageItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = ImageItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateMoviePresenter(title:String) {
        Log.d(TAG, "updateMoviePresenter")
        val list: ArrayList<MovieItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as MovieItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = MovieItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateDictPresenter(title:String) {
        Log.d(TAG, "updateDictPresenter")
        val list: ArrayList<DictItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as DictItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = DictItemsAdapter(
            mRequestManager
        )
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateCafePresenter(title:String) {
        Log.d(TAG, "updateCafePresenter")
        val list: ArrayList<CafeItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as CafeItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = CafeItemsAdapter(
        )
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateKnowPresenter(title:String) {
        Log.d(TAG, "updateKnowPresenter")
        val list: ArrayList<KnowItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as KnowItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = KnowItemsAdapter(
        )
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateLocalPresenter(title:String) {
        Log.d(TAG, "updateLocalPresenter")
        val list: ArrayList<LocationItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as LocationItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = LocalItemsAdapter()
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateWebPresenter(title:String) {
        Log.d(TAG, "updateWebPresenter")
        val list: ArrayList<WebItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as WebItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = WebItemsAdapter()
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }

    private fun updateReferPresenter(title:String) {
        Log.d(TAG, "updateReferPresenter")
        val list: ArrayList<ReferItemsModel> = ArrayList()
        try {
            for (element in mList) {
                list.add(element as ReferItemsModel)
            }
        } catch (e: TypeCastException) {

        }

        val adapter = ReferItemsAdapter()
        adapter.setList(list)
        mView.rview.adapter = adapter
        mView.title.text = title
    }
}