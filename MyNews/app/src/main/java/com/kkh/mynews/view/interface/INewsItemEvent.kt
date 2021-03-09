package com.kkh.mynews.view.`interface`

import com.kkh.mynews.item.news.model.NewsItemsModel

interface INewsItemEvent {
    fun onBindItem(data: NewsItemsModel)
}