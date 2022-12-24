package com.example.tmdbclientapp.data.repository.artist.datasource

import com.example.tmdbclientapp.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
}