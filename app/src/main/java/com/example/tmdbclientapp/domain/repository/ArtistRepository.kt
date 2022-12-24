package com.example.tmdbclientapp.domain.repository

import com.example.tmdbclientapp.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}