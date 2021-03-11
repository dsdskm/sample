package com.kkh.mynews.data.item.cafe.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cafeItems")
data class CafeItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var cafename: String = "",
    var cafeurl: String = "",
    var query: String = ""
)