package com.kkh.mynews.data.item.blog.model

import com.kkh.mynews.data.item.blog.model.BlogItemsModel

data class BlogModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<BlogItemsModel>? = null
)
