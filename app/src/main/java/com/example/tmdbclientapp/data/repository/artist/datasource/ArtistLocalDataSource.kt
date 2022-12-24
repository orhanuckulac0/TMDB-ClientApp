package com.example.tmdbclientapp.data.repository.artist.datasource

import com.example.tmdbclientapp.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artists: List<Artist>)
    suspend fun clearAll()
}