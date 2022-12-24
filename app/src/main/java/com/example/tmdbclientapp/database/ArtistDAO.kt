package com.example.tmdbclientapp.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientapp.model.artist.Artist

interface ArtistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(): List<Artist>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllArtists(): List<Artist>

    @Query("SELECT * FROM popular_movies")
    suspend fun getArtists(): List<Artist>
}