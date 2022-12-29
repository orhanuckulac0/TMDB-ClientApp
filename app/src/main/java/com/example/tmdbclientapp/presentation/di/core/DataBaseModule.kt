package com.example.tmdbclientapp.presentation.di.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tmdbclientapp.data.db.ArtistDAO
import com.example.tmdbclientapp.data.db.MovieDAO
import com.example.tmdbclientapp.data.db.TMDBDatabase
import com.example.tmdbclientapp.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application): TMDBDatabase{
        return Room.databaseBuilder(app, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDAO()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDAO {
        return tmdbDatabase.tvShowDAO()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDAO {
        return tmdbDatabase.artistDAO()
    }

}