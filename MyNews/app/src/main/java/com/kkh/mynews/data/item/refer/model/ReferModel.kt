package com.kkh.mynews.data.item.refer.model

data class ReferModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<ReferItemsModel>? = null
)
