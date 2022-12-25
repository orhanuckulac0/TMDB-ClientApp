package com.example.tmdbclientapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclientapp.domain.use_case.GetMoviesUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModel() {

    // use a livedata coroutine builder(which creates a coroutine in the ui thread) to convert the list to a livedata and emit.
    // So we can observe it from the activity.
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}