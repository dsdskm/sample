package com.kkh.mynews.data.item.news.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsItems")
data class NewsItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var originallink: String = "",
    var link: String = "",
    var description: String = "",
    var pubDate: String = "",
    var query:String=""
)