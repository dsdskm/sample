package com.kkh.mynews.data.item.book.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.book.model.BookItemsModel

@Dao
interface BookItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<BookItemsModel>)

    @Query("SELECT * FROM bookItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, BookItemsModel>

    @Query("DELETE FROM bookItems")
    fun deleteAll()

    @Query("DELETE FROM bookItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}