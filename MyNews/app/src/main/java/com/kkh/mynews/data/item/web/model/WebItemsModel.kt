package com.kkh.mynews.data.item.web.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "webItems")
data class WebItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var query:String=""
)