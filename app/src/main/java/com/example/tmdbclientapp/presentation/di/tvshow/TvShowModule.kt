package com.example.tmdbclientapp.presentation.di.tvshow

import com.example.tmdbclientapp.domain.use_case.GetTvShowUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateTvShowUseCase
import com.example.tmdbclientapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class TvShowModule {

    @ActivityScoped
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }

}