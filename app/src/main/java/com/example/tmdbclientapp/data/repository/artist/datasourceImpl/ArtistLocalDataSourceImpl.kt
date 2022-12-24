package com.example.tmdbclientapp.data.repository.artist.datasourceImpl

import com.example.tmdbclientapp.data.db.ArtistDAO
import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDAO: ArtistDAO): ArtistLocalDataSource {

    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDAO.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtist(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtists()
        }
    }
}