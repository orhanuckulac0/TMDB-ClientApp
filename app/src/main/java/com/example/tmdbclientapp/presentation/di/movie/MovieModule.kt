package com.example.tmdbclientapp.presentation.di.movie

import com.example.tmdbclientapp.domain.use_case.GetMoviesUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateMoviesUseCase
import com.example.tmdbclientapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
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