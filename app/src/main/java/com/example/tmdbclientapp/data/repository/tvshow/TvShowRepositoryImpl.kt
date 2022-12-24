package com.example.tmdbclientapp.data.repository.tvshow

import android.util.Log
import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclientapp.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null){
                tvShowsList = body.tvShows
            }
            return tvShowsList
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowLocalDataSource.getTvShowFromDB()
            return tvShowsList
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }

        if (tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (e: Exception){
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowsList)
        }
        return tvShowsList
    }
}