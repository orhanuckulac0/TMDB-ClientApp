package com.example.tmdbclientapp.presentation.di.core

import android.content.Context
import com.example.tmdbclientapp.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclientapp.presentation.di.movie.MovieSubComponent
import com.example.tmdbclientapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    ArtistSubComponent::class
])
class AppModule(private val context: Context) {

    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}