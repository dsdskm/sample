package com.kkh.mynews.item.keyword.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kkh.mynews.item.news.model.NewsItemsModel

@Entity(tableName = "keyword")
data class KeywordModel(
    @PrimaryKey var keyword: String = "",
    var time: Long = 0
)
