package com.example.feature_auth_impl.di

import com.example.feature_auth_api.data.AuthNavigationRepository
import com.example.feature_auth_impl.data.AuthNavigationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    @AuthScope
    fun provideNavigationRepository(impl: AuthNavigationRepositoryImpl): AuthNavigationRepository
}