package com.kkh.mynews.data.item.image.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.image.model.ImageItemsModel

@Dao
interface ImageItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<ImageItemsModel>)

    @Query("SELECT * FROM imageItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, ImageItemsModel>

    @Query("DELETE FROM imageItems")
    fun deleteAll()

    @Query("DELETE FROM imageItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}