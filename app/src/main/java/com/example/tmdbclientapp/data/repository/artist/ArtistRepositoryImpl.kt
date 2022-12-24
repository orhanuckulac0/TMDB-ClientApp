package com.example.tmdbclientapp.data.repository.artist

import android.util.Log
import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclientapp.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistsList : List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null){
                artistsList = body.artists
            }
            return artistsList

        }catch (e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        return artistsList
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistLocalDataSource.getArtistFromDB()
        }catch (e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if (artistsList.isNotEmpty()){
            return artistsList
        }else{
            artistsList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistsList)
        }

        return artistsList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistCacheDataSource.getArtistFromCache()
        }catch (e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if (artistsList.isNotEmpty()){
            return artistsList
        }else{
            artistsList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistsList)
        }

        return artistsList
    }
}