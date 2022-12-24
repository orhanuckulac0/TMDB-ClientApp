package com.example.tmdbclientapp.domain.usecase

import com.example.tmdbclientapp.domain.repository.MovieRepository
import com.example.tmdbclientapp.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}