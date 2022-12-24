package com.example.tmdbclientapp.data.repository.artist.datasourceImpl

import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}