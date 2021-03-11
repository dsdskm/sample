package com.kkh.mynews.data.item.movie.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kkh.mynews.data.item.movie.model.MovieItemsModel

@Dao
interface MovieItemsDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: List<MovieItemsModel>)

    @Query("SELECT * FROM locationItems ORDER BY uid ASC")
    fun loadPagedList(): DataSource.Factory<Int, MovieItemsModel>

    @Query("DELETE FROM movieItems")
    fun deleteAll()

    @Query("DELETE FROM movieItems WHERE query=:query")
    fun deleteAllByQuery(query:String)

}