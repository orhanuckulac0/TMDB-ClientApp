package com.example.tmdbclientapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclientapp.domain.use_case.GetMoviesUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
        }
    }