package com.kkh.mynews.data.item.blog.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.blog.model.BlogItemsModel

@Dao
interface BlogItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<BlogItemsModel>)

    @Query("SELECT * FROM blogItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, BlogItemsModel>

    @Query("DELETE FROM blogItems")
    fun deleteAll()

    @Query("DELETE FROM blogItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}