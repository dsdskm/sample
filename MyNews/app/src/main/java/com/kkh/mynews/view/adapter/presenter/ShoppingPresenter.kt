package com.kkh.mynews.view.adapter.presenter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.view.adapter.ContentsAdapter
import com.kkh.mynews.view.adapter.NewsItemsAdapter
import com.kkh.mynews.view.adapter.ShoppingItemsAdapter

class ShoppingPresenter {
    fun update(list: List<Any>, holder: ContentsAdapter.ViewHolder) {
        val shoppingList: ArrayList<ShoppingItemsModel> = ArrayList()
        for (element in list) {
            shoppingList.add(element as ShoppingItemsModel)
        }
        val adapter = ShoppingItemsAdapter()
        adapter.setList(shoppingList)
        holder.mRecyclerView.adapter = adapter
        holder.mTitle.text = "Shopping"
    }
}