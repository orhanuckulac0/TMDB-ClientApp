package com.example.tmdbclientapp.data.repository.movie.datasourceImpl

import com.example.tmdbclientapp.data.db.MovieDAO
import com.example.tmdbclientapp.data.model.movie.Movie
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}