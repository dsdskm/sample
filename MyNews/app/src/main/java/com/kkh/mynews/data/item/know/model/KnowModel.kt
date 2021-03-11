package com.kkh.mynews.data.item.know.model

data class KnowModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<KnowItemsModel>? = null
)
