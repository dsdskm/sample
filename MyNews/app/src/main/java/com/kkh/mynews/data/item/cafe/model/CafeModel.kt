package com.kkh.mynews.data.item.cafe.model

import com.kkh.mynews.data.item.cafe.model.CafeItemsModel

data class CafeModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<CafeItemsModel>? = null
)
