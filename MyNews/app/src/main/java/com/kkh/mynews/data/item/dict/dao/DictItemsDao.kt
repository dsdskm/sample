package com.kkh.mynews.data.item.dict.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.dict.model.DictItemsModel

@Dao
interface DictItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<DictItemsModel>)

    @Query("SELECT * FROM dictItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, DictItemsModel>

    @Query("DELETE FROM dictItems")
    fun deleteAll()

    @Query("DELETE FROM dictItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}