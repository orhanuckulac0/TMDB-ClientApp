package com.example.tmdbclientapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.data.model.movie.Movie
import com.example.tmdbclientapp.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDAO(): MovieDAO
    abstract fun tvShowDAO(): TvShowDAO
    abstract fun artistDAO(): ArtistDAO

}