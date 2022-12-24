package com.example.tmdbclientapp.data.repository.tvshow.datasource

import com.example.tmdbclientapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(artists: List<TvShow>)
}