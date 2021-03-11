package com.kkh.mynews.data.item.web.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.web.model.WebItemsModel

@Dao
interface WebItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<WebItemsModel>)

    @Query("SELECT * FROM webItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, WebItemsModel>

    @Query("DELETE FROM webItems")
    fun deleteAll()

    @Query("DELETE FROM webItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}