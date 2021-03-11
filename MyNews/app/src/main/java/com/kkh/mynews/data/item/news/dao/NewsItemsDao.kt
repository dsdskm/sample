package com.kkh.mynews.data.item.news.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.news.model.NewsItemsModel

@Dao
interface NewsItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<NewsItemsModel>)

    @Query("SELECT * FROM newsItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, NewsItemsModel>

    @Query("DELETE FROM newsItems")
    fun deleteAll()

    @Query("DELETE FROM newsItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}