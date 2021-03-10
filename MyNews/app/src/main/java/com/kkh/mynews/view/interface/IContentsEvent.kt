package com.kkh.mynews.view.`interface`

import com.kkh.mynews.item.contents.ContentsModel
import com.kkh.mynews.item.news.model.NewsItemsModel

interface IContentsEvent {
    fun onBindItem(data: ContentsModel)
}