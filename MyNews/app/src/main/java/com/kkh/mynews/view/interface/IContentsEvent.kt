package com.kkh.mynews.view.`interface`

import com.kkh.mynews.data.item.contents.ContentsModel

interface IContentsEvent {
    fun onBindItem(data: ContentsModel)
}