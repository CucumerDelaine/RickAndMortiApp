package com.example.feature_details_impl.di.module

import com.example.feature_details_api.data.DetailsNavigationRepository
import com.example.feature_details_impl.data.DetailsNavigationRepositoryImpl
import com.example.feature_details_impl.di.scope.DetailsScope
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {
    @Binds
    @DetailsScope
    fun provideNavigationRepository(impl: DetailsNavigationRepositoryImpl): DetailsNavigationRepository
}