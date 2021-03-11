package com.kkh.mynews.data.item.location.model

data class LocationModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var category: String = "",
    var items: List<LocationItemsModel>? = null
)
