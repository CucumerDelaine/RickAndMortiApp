package com.example.feature_characterlist_impl.di

import androidx.lifecycle.ViewModel
import com.example.core.viewModel.ViewModelKey
import com.example.feature_characterlist_api.data.model.CharacterConverter
import com.example.feature_characterlist_api.data.repository.CacheRepository
import com.example.feature_characterlist_api.data.repository.NetworkRepository
import com.example.feature_characterlist_api.data.repository.TimeAndPageInfoRepository
import com.example.feature_characterlist_api.domain.ClearDatabaseUseCase
import com.example.feature_characterlist_api.domain.GetAndSaveCharacterListUseCase
import com.example.feature_characterlist_api.domain.GetAppInfoUseCase
import com.example.feature_characterlist_api.domain.SaveAppInfoUseCase
import com.example.feature_characterlist_impl.data.repository.CacheRepositoryImpl
import com.example.feature_characterlist_impl.data.repository.NetworkRepositoryImpl
import com.example.feature_characterlist_impl.data.repository.TimeAndPageInfoRepositoryImpl
import com.example.feature_characterlist_impl.domain.ClearDatabaseUseCaseImpl
import com.example.feature_characterlist_impl.domain.GetAndSaveCharacterListUseCaseImpl
import com.example.feature_characterlist_impl.domain.GetAppInfoUseCaseImpl
import com.example.feature_characterlist_impl.domain.SaveAppInfoUseCaseImpl
import com.example.feature_characterlist_impl.presentation.viewModel.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface CharacterListModule {

    @Binds
    @CharacterListScope
    fun provideCacheRepository(cacheRepository: CacheRepositoryImpl): CacheRepository

    @Binds
    @CharacterListScope
    fun provideNetworkRepository(networkRepository: NetworkRepositoryImpl): NetworkRepository

    @Binds
    @CharacterListScope
    fun provideTimeAndPageInfoRepository(timeAndPageInfoRepository: TimeAndPageInfoRepositoryImpl): TimeAndPageInfoRepository

    @Binds
    @CharacterListScope
    fun provideClearDatabaseUseCase(clearDatabaseUseCase: ClearDatabaseUseCaseImpl): ClearDatabaseUseCase

    @Binds
    @CharacterListScope
    fun provideLoadCharacterListUseCase(loadCharacterListUseCase: GetAndSaveCharacterListUseCaseImpl): GetAndSaveCharacterListUseCase

    @Binds
    @CharacterListScope
    fun provideGetAppInfoUseCase(getAppInfoUseCase: GetAppInfoUseCaseImpl): GetAppInfoUseCase

    @Binds
    @CharacterListScope
    fun provideSaveAppInfoUseCase(saveAppInfoUseCase: SaveAppInfoUseCaseImpl): SaveAppInfoUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    fun bindViewModel(characterListViewModel: CharacterListViewModel): ViewModel

    @Binds
    @CharacterListScope
    fun provideCharacterListModel(characterListModel: com.example.feature_characterlist_impl.data.model.CharacterConverterImpl): CharacterConverter

}