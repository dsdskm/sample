package com.kkh.mynews.data.item.location.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.location.model.LocationItemsModel

@Dao
interface LocationItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<LocationItemsModel>)

    @Query("SELECT * FROM locationItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, LocationItemsModel>

    @Query("DELETE FROM locationItems")
    fun deleteAll()

    @Query("DELETE FROM locationItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}