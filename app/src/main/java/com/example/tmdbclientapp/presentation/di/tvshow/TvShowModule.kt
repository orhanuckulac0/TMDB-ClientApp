package com.example.tmdbclientapp.presentation.di.tvshow

import com.example.tmdbclientapp.domain.use_case.GetTvShowUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateTvShowUseCase
import com.example.tmdbclientapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }

}