package com.kkh.mynews.item.keyword.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.item.news.model.NewsItemsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface KeywordDao {
    @Insert(onConflict = REPLACE)
    fun insertAll(data: List<KeywordModel>)

    @Insert(onConflict = REPLACE)
    fun insert(data: KeywordModel)

    @Query("SELECT * FROM keyword ORDER BY time DESC")
    fun load(): Flow<List<KeywordModel>>

    @Query("DELETE FROM keyword WHERE keyword=:keyword")
    fun deleteByKeyword(keyword:String)

}