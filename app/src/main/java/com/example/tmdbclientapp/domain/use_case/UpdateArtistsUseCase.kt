package com.example.tmdbclientapp.domain.use_case

import com.example.tmdbclientapp.domain.repository.ArtistRepository
import com.example.tmdbclientapp.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}