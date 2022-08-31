package com.example.feature_characterlist_impl.di

import androidx.lifecycle.ViewModel
import com.example.core.viewModel.ViewModelKey
import com.example.feature_characterlist_impl.domain.ClearDatabaseUseCaseImpl
import com.example.feature_characterlist_impl.domain.GetAndSaveCharacterListUseCaseImpl
import com.example.feature_characterlist_impl.presentation.viewModel.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface CharacterListModule {

    @Binds
    @CharacterListScope
    fun provideCacheRepository(cacheRepository: com.example.feature_characterlist_impl.data.repository.CacheRepositoryImpl): com.example.feature_characterlist_api.data.repository.CacheRepository

    @Binds
    @CharacterListScope
    fun provideNetworkRepository(networkRepository: com.example.feature_characterlist_impl.data.repository.NetworkRepositoryImpl): com.example.feature_characterlist_api.data.repository.NetworkRepository

    @Binds
    @CharacterListScope
    fun provideClearDatabaseUseCase(clearDatabaseUseCase: ClearDatabaseUseCaseImpl): com.example.feature_characterlist_api.domain.ClearDatabaseUseCase

    @Binds
    @CharacterListScope
    fun provideLoadCharacterListUseCase(loadCharacterListUseCase: GetAndSaveCharacterListUseCaseImpl): com.example.feature_characterlist_api.domain.GetAndSaveCharacterListUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    fun bindViewModel(characterListViewModel: CharacterListViewModel): ViewModel

    @Binds
    @CharacterListScope
    fun provideCharacterListModel(characterListModel: com.example.feature_characterlist_impl.data.model.CharacterConverterImpl): com.example.feature_characterlist_api.data.model.CharacterConverter

}