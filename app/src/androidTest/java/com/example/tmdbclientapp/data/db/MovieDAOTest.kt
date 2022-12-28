package com.example.tmdbclientapp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclientapp.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDAOTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDAO
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp(){
        // inMemoryDatabaseBuilder allows us to create temporary db for testing.
        // db will be created in system memory. when we kill the process, db will be removed and data will not be persisted
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao =database.movieDAO()
    }

    @After
    fun tearDown(){
        // we also need to write code to close the db after we are done.
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking{
        // create  a list of movie obj
        val movies = listOf(
            Movie(1, "test1", "test1Path", "testDate1", "title1"),
            Movie(2, "test2", "test2Path", "testDate2", "title2"),
            Movie(3, "test3", "test3Path", "testDate3", "title3")
        )
        // save them to db
        dao.saveMovies(movies)

        // retrieve them from db
        val retrievedMovies = dao.getMovies()

        // compare with original list
        Truth.assertThat(movies).isEqualTo(retrievedMovies)
    }
}