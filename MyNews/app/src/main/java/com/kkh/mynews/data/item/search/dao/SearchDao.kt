package com.kkh.mynews.data.item.shopping.dao

import android.database.Cursor
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kkh.mynews.data.item.search.model.SearchModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel

@Dao
interface SearchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: SearchModel)

    @Query("SELECT * FROM search ORDER BY _id ASC")
    fun loadPagedList(): Cursor

    @Query("DELETE FROM search")
    fun deleteAll()

}