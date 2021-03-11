package com.kkh.mynews.data.item.image.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "imageItems")
data class ImageItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var thumbnail: String = "",
    var sizeheight: String = "",
    var sizewidth: String = "",
    var query:String=""
)