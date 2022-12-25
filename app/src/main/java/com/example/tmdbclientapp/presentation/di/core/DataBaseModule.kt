package com.example.tmdbclientapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclientapp.data.db.ArtistDAO
import com.example.tmdbclientapp.data.db.MovieDAO
import com.example.tmdbclientapp.data.db.TMDBDatabase
import com.example.tmdbclientapp.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
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