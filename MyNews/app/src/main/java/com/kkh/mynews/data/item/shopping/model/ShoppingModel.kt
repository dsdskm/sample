package com.kkh.mynews.data.item.shopping.model

data class ShoppingModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<ShoppingItemsModel>? = null
)