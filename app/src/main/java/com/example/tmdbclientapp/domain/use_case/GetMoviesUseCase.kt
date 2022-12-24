package com.example.tmdbclientapp.domain.use_case

import com.example.tmdbclientapp.domain.repository.MovieRepository
import com.example.tmdbclientapp.data.model.movie.Movie


// use class cannot do it without getting support from a repository
// we need a repository which has a function, returns a list of movie instances
// and we will be able to inject an instance of that repository to the use case class as a constructor parameter
class GetMoviesUseCase(private val movieRepository: MovieRepository){
    // fun which returns a list of movie instances
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}