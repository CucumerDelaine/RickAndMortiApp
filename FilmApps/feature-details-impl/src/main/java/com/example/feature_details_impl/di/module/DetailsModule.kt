package com.example.feature_details_impl.di.module

import androidx.lifecycle.ViewModel
import com.example.core.viewModel.ViewModelKey
import com.example.feature_details_api.data.GetCharacterRepository
import com.example.feature_details_api.domain.GetCharacterDetailsUseCase
import com.example.feature_details_api.model.ResultCharacterResponseModel
import com.example.feature_details_impl.data.GetCharacterRepositoryImpl
import com.example.feature_details_impl.di.scope.DetailsScope
import com.example.feature_details_impl.domain.GetCharacterDetailsUseCaseImpl
import com.example.feature_details_impl.presentation.model.ResultCharacterResponseModelImpl
import com.example.feature_details_impl.presentation.viewModel.CharacterDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface DetailsModule {

    @Binds
    @DetailsScope
    fun provideRetrofitRepositories(getCharacterRepository: GetCharacterRepositoryImpl): GetCharacterRepository

    @Binds
    @DetailsScope
    fun provideGetCharacterDetailsUseCase(getCharacterDetailsUseCase: GetCharacterDetailsUseCaseImpl): GetCharacterDetailsUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    fun bindViewModel(characterDetailsViewModel: CharacterDetailsViewModel): ViewModel

    @Binds
    @DetailsScope
    fun provideCharacterConverter(characterConverter: ResultCharacterResponseModelImpl): ResultCharacterResponseModel
}