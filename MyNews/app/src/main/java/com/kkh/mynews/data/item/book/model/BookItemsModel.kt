package com.kkh.mynews.data.item.book.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookItems")
data class BookItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var image: String = "",
    var author: String = "",
    var price: Int = 0,
    var discount: Int = 0,
    var publisher: String = "",
    var description: String = "",
    var query:String=""
)