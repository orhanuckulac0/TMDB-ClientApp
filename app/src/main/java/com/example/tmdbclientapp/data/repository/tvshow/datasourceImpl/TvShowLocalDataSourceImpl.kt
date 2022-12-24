package com.example.tmdbclientapp.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientapp.data.db.TvShowDAO
import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDAO: TvShowDAO): TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDAO.getTvShows()
    }

    override suspend fun saveTvShowToDB(artists: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShow(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}