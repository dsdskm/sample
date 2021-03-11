package com.kkh.mynews.data.item.location.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locationItems")
data class LocationItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var telephone: String = "",
    var address: String = "",
    var roadAddress: String = "",
    var mapx: Int = 0,
    var mapy: Int = 0,
    var query: String = ""
)