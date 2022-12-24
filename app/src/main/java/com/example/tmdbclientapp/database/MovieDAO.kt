package com.example.tmdbclientapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientapp.model.movie.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(): List<Movie>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies(): List<Movie>

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}