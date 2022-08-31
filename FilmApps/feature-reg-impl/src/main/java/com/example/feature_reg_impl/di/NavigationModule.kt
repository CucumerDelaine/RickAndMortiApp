package com.example.feature_reg_impl.di

import com.example.feature_reg_api.data.RegNavigationRepository
import com.example.feature_reg_impl.data.RegNavigationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {
    @Binds
    @RegScope
    fun provideNavigationRepository(impl: RegNavigationRepositoryImpl): RegNavigationRepository
}