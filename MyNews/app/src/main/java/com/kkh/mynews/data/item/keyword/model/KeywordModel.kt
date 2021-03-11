package com.kkh.mynews.data.item.keyword.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keyword")
data class KeywordModel(
    @PrimaryKey var keyword: String = "",
    var time: Long = 0
)
