package com.kkh.mynews.data.item.web.model

import com.kkh.mynews.data.item.web.model.WebItemsModel

data class WebModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<WebItemsModel>? = null
)
