package com.kkh.mynews.data.item.know.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.blog.model.*
import com.kkh.mynews.data.item.know.model.KnowItemsModel

@Dao
interface KnowItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<KnowItemsModel>)

    @Query("SELECT * FROM knowItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, KnowItemsModel>

    @Query("DELETE FROM knowItems")
    fun deleteAll()

    @Query("DELETE FROM knowItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}