package com.example.tmdbclientapp.domain.use_case

import com.example.tmdbclientapp.domain.repository.TvShowRepository
import com.example.tmdbclientapp.data.model.tvshow.TvShow

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}