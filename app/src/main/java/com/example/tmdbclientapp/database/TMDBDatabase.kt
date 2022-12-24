package com.example.tmdbclientapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclientapp.model.artist.Artist
import com.example.tmdbclientapp.model.movie.Movie
import com.example.tmdbclientapp.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDAO(): MovieDAO
    abstract fun tvShowDAO(): TvShowDAO
    abstract fun artistDAO(): ArtistDAO

}