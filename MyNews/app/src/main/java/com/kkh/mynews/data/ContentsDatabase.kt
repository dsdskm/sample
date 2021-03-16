package com.kkh.mynews.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kkh.mynews.data.item.keyword.dao.KeywordDao
import com.kkh.mynews.data.item.news.dao.NewsItemsDao
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.dao.BlogItemsDao
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.dao.BookItemsDao
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.cafe.dao.CafeItemsDao
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
import com.kkh.mynews.data.item.dict.dao.DictItemsDao
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.data.item.image.dao.ImageItemsDao
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.image.model.ImageModel
import com.kkh.mynews.data.item.know.dao.KnowItemsDao
import com.kkh.mynews.data.item.know.model.KnowItemsModel
import com.kkh.mynews.data.item.location.dao.LocationItemsDao
import com.kkh.mynews.data.item.location.model.LocationItemsModel
import com.kkh.mynews.data.item.movie.dao.MovieItemsDao
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.data.item.refer.dao.ReferItemsDao
import com.kkh.mynews.data.item.refer.model.ReferItemsModel
import com.kkh.mynews.data.item.search.model.SearchModel
import com.kkh.mynews.data.item.shopping.dao.SearchDao
import com.kkh.mynews.data.item.shopping.dao.ShoppingItemsDao
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.data.item.web.dao.WebItemsDao
import com.kkh.mynews.data.item.web.model.WebItemsModel

@Database(
    entities = [
        BlogItemsModel::class,
        BookItemsModel::class,
        CafeItemsModel::class,
        DictItemsModel::class,
        ImageItemsModel::class,
        KnowItemsModel::class,
        LocationItemsModel::class,
        MovieItemsModel::class,
        NewsItemsModel::class,
        ReferItemsModel::class,
        ShoppingItemsModel::class,
        WebItemsModel::class,
        KeywordModel::class,
        SearchModel::class
    ], version = 1
)
abstract class ContentsDatabase : RoomDatabase() {
    abstract fun blogItemsDao(): BlogItemsDao
    abstract fun bookItemsDao(): BookItemsDao
    abstract fun cafeItemsDao(): CafeItemsDao
    abstract fun dictItemsDao(): DictItemsDao
    abstract fun imageItemsDao(): ImageItemsDao
    abstract fun knowItemsDao(): KnowItemsDao
    abstract fun locationItemsDao(): LocationItemsDao
    abstract fun movieItemsDao(): MovieItemsDao
    abstract fun newsItemDao(): NewsItemsDao
    abstract fun referItemsDao(): ReferItemsDao
    abstract fun shoppingItemsDao(): ShoppingItemsDao
    abstract fun keywordDao(): KeywordDao
    abstract fun webItemsDao(): WebItemsDao
    abstract fun searchModelDao(): SearchDao

}