package com.kkh.mynews.item.shopping.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kkh.mynews.item.news.model.NewsItemsModel

data class ShoppingModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<ShoppingItemsModel>? = null
)