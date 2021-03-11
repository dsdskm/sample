package com.kkh.mynews.data.item.image.model

data class ImageModel(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<ImageItemsModel>? = null
)
