package com.kkh.mynews.data.item.know.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "knowItems")
data class KnowItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var query: String = ""
)