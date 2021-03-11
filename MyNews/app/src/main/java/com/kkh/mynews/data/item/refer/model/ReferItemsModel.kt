package com.kkh.mynews.data.item.refer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "referItems")
data class ReferItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var query:String=""
)