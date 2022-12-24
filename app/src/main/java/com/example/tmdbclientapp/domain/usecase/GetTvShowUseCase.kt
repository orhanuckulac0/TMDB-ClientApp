package com.example.tmdbclientapp.domain.usecase

import com.example.tmdbclientapp.domain.repository.TvShowRepository
import com.example.tmdbclientapp.model.tvshow.TvShow

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}