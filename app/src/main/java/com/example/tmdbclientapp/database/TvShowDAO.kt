package com.example.tmdbclientapp.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientapp.model.tvshow.TvShow

interface TvShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(): List<TvShow>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllTvShows(): List<TvShow>

    @Query("SELECT * FROM popular_movies")
    suspend fun getTvShows(): List<TvShow>
}