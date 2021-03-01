package com.kkh.mynews.model

import com.kkh.mynews.item.news.model.NewsItemsModel

data class NewsModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<NewsItemsModel>? = null
)
