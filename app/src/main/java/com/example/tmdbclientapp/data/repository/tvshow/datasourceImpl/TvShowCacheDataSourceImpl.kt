package com.example.tmdbclientapp.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(artists: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(artists)
    }
}