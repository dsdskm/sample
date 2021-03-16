package com.kkh.mynews.data.item.search.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search")
data class SearchModel(
    @PrimaryKey(autoGenerate = true)
    var _id:Int = 0,
    var word:String
)