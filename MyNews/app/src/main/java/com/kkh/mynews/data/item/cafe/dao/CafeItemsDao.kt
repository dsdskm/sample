package com.kkh.mynews.data.item.cafe.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel

@Dao
interface CafeItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<CafeItemsModel>)

    @Query("SELECT * FROM cafeItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, CafeItemsModel>

    @Query("DELETE FROM cafeItems")
    fun deleteAll()

    @Query("DELETE FROM cafeItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}