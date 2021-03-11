package com.kkh.mynews.data.item.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieItems")
data class MovieItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var image: String = "",
    var subtitle: String = "",
    var pubDate: String = "",
    var director: String = "",
    var actor: String = "",
    var userRating: Int = 0,
    var query: String = ""
)