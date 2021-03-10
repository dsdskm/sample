package com.kkh.mynews.item.shopping.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kkh.mynews.item.shopping.model.ShoppingItemsModel

@Dao
interface ShoppingItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<ShoppingItemsModel>)

    @Query("SELECT * FROM shoppingItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, ShoppingItemsModel>

    @Query("DELETE FROM shoppingItems")
    fun deleteAll()

    @Query("DELETE FROM shoppingItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}