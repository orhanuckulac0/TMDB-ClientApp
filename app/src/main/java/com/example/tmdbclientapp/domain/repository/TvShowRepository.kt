package com.example.tmdbclientapp.domain.repository

import com.example.tmdbclientapp.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}