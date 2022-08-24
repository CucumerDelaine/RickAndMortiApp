package com.example.filmapps.feature.characterListAndDetails.characterList.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.feature.characterListAndDetails.characterList.di.scope.CharacterListScope
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import com.example.filmapps.feature.characterListAndDetails.characterList.domain.useCase.*
import com.example.filmapps.feature.characterListAndDetails.characterList.data.model.CharacterConverter
import com.example.filmapps.feature.characterListAndDetails.characterList.data.model.CharacterConverterImpl
import com.example.filmapps.feature.characterListAndDetails.characterList.data.repository.*
import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.viewModel.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface CharacterListModule {

    @Binds
    @CharacterListScope
    fun provideCacheRepository(cacheRepository: CacheRepositoryImpl) : CacheRepository

    @Binds
    @CharacterListScope
    fun provideNetworkRepository(networkRepository: NetworkRepositoryImpl) : NetworkRepository

    @Binds
    @CharacterListScope
    fun provideClearDatabaseUseCase(clearDatabaseUseCase: ClearDatabaseUseCaseImpl) : ClearDatabaseUseCase

    @Binds
    @CharacterListScope
    fun provideLoadCharacterListUseCase(loadCharacterListUseCase: GetAndSaveCharacterListUseCaseImpl) : GetAndSaveCharacterListUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    fun bindViewModel(characterListViewModel: CharacterListViewModel): ViewModel

    @Binds
    @CharacterListScope
    fun provideCharacterListModel(characterListModel: CharacterConverterImpl) : CharacterConverter

}