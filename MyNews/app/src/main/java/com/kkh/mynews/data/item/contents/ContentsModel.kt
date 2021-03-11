package com.kkh.mynews.data.item.contents

data class ContentsModel(
    val uid: Int,
    val viewType: Int,
    val query:String,
    val list: List<Any>
)