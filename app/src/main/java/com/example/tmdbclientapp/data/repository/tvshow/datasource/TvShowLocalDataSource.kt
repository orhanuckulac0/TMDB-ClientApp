package com.example.tmdbclientapp.data.repository.tvshow.datasource

import com.example.tmdbclientapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(artists: List<TvShow>)
    suspend fun clearAll()
}