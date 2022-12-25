package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclientapp.presentation.di.movie.MovieSubComponent
import com.example.tmdbclientapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    CacheDataModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}