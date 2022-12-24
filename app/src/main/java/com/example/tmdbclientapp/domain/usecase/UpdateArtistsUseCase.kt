package com.example.tmdbclientapp.domain.usecase

import com.example.tmdbclientapp.domain.repository.ArtistRepository
import com.example.tmdbclientapp.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}