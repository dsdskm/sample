package com.kkh.mynews.data.item.blog.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blogItems")
data class BlogItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var bloggername: String = "",
    var bloggerlink: String = "",
    var query:String=""
)