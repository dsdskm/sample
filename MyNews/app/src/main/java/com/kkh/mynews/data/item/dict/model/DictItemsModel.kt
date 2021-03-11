package com.kkh.mynews.data.item.dict.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictItems")
data class DictItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var thumbnail: String = "",
    var query:String=""
)