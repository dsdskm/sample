package com.kkh.mynews.item.news.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.item.news.model.NewsItemsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<NewsItemsModel>)

    @Query("SELECT * FROM newsItems ORDER BY uid DESC")
    fun load(): Flow<List<NewsItemsModel>>

    @Query("DELETE FROM newsItems")
    fun deleteAll()

    @Query("DELETE FROM newsItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}