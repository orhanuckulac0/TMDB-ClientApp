package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.BuildConfig
import com.example.tmdbclientapp.data.api.TMDBService
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclientapp.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclientapp.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,
            BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService,
            BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService,
            BuildConfig.API_KEY
        )
    }
}