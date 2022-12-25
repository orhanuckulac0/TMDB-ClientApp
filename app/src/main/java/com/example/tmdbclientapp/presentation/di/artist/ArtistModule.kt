package com.example.tmdbclientapp.presentation.di.artist

import com.example.tmdbclientapp.domain.use_case.GetArtistsUseCase
import com.example.tmdbclientapp.domain.use_case.UpdateArtistsUseCase
import com.example.tmdbclientapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}