package com.kkh.mynews.data.item.dict.model

import com.kkh.mynews.data.item.book.model.BookItemsModel

data class DictModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<DictItemsModel>? = null
)
