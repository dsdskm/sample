package com.kkh.mynews.data.item.refer.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.refer.model.ReferItemsModel

@Dao
interface ReferItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<ReferItemsModel>)

    @Query("SELECT * FROM referItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, ReferItemsModel>

    @Query("DELETE FROM referItems")
    fun deleteAll()

    @Query("DELETE FROM referItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}