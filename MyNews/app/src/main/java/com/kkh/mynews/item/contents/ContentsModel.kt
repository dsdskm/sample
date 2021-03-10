package com.kkh.mynews.item.contents

import com.kkh.mynews.item.news.model.NewsItemsModel

data class ContentsModel(
    val uid: Int,
    val viewType: Int,
    val query:String,
    val list: List<Any>
)