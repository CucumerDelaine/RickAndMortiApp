package com.example.feature_characterlist_impl.di

import com.example.feature_characterlist_api.data.repository.CharacterListNavigationRepository
import com.example.feature_characterlist_impl.data.repository.CharacterListNavigationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {
    @Binds
    @CharacterListScope
    fun provideNavigationRepository(impl: CharacterListNavigationRepositoryImpl): CharacterListNavigationRepository
}