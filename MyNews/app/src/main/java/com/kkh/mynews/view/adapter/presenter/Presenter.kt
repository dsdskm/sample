package com.kkh.mynews.view.adapter.presenter

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kkh.mynews.item.contents.ContentsModel
import com.kkh.mynews.view.adapter.ContentsAdapter

class Presenter {

    val mNewsPresenter: NewsPresenter = NewsPresenter()
    val mShoppingPresenter: ShoppingPresenter = ShoppingPresenter()

    fun update(data: ContentsModel, holder: ContentsAdapter.ViewHolder) {
        holder.mRecyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.mRecyclerView.itemAnimator = DefaultItemAnimator()
        holder.mRecyclerView.setHasFixedSize(true)
        when (data.viewType) {
            ContentsAdapter.VIEW_TYPE_NEWS -> mNewsPresenter.update(data.list, holder)
            ContentsAdapter.VIEW_TYPE_SHOPPING -> mShoppingPresenter.update(data.list, holder)
        }
    }
}