package com.kkh.mynews.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kkh.mynews.item.keyword.dao.KeywordDao
import com.kkh.mynews.item.news.dao.NewsItemsDao
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.item.shopping.dao.ShoppingItemsDao
import com.kkh.mynews.item.shopping.model.ShoppingItemsModel

@Database(entities = [NewsItemsModel::class, KeywordModel::class,ShoppingItemsModel::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsItemDao(): NewsItemsDao
    abstract fun keywordDao(): KeywordDao
    abstract fun shoppingItemsDao(): ShoppingItemsDao
}