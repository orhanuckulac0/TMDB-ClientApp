package com.example.tmdbclientapp.presentation.di.movie

import com.example.tmdbclientapp.domain.use_case.GetMoviesUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateMoviesUseCase
import com.example.tmdbclientapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {

    @ActivityScoped
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase, updateMoviesUseCase
        )
    }

}