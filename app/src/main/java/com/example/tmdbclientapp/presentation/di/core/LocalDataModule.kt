package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.data.db.ArtistDAO
import com.example.tmdbclientapp.data.db.MovieDAO
import com.example.tmdbclientapp.data.db.TvShowDAO
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclientapp.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclientapp.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDAO)
    }
}