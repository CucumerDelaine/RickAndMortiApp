package com.example.filmapps.feature.characterListAndDetails.details.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.feature.characterListAndDetails.details.data.repository.GetCharacterRepository
import com.example.filmapps.feature.characterListAndDetails.details.data.repository.GetCharacterRepositoryImpl
import com.example.filmapps.feature.characterListAndDetails.details.di.scope.DetailsScope
import com.example.filmapps.feature.characterListAndDetails.details.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.feature.characterListAndDetails.details.domain.useCase.GetCharacterDetailsUseCaseImpl
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import com.example.filmapps.feature.characterListAndDetails.details.presentation.ui.ResultCharacterResponseModel
import com.example.filmapps.feature.characterListAndDetails.details.presentation.ui.ResultCharacterResponseModelImpl
import com.example.filmapps.feature.characterListAndDetails.details.presentation.viewModel.CharacterDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface DetailsModule {

    @Binds
    @DetailsScope
    fun provideRetrofitRepositories(getCharacterRepository: GetCharacterRepositoryImpl) : GetCharacterRepository

    @Binds
    @DetailsScope
    fun provideGetCharacterDetailsUseCase(getCharacterDetailsUseCase: GetCharacterDetailsUseCaseImpl) : GetCharacterDetailsUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    fun bindViewModel(characterDetailsViewModel: CharacterDetailsViewModel): ViewModel

    @Binds
    @DetailsScope
    fun provideCharacterConverter(characterConverter: ResultCharacterResponseModelImpl) : ResultCharacterResponseModel
}