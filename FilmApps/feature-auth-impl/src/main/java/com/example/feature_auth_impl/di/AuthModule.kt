package com.example.feature_auth_impl.di

import androidx.lifecycle.ViewModel
import com.example.core.viewModel.ViewModelKey
import com.example.feature_auth_api.data.AuthRepository
import com.example.feature_auth_api.domain.GetInfoAboutRegisterUseCase
import com.example.feature_auth_impl.data.AuthRepositoryImpl
import com.example.feature_auth_impl.domain.GetInfoAboutRegisterUseCaseImpl
import com.example.feature_auth_impl.presentation.viewModel.AuthorizationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface AuthModule {

    @Binds
    @AuthScope
    fun provideUserRepositories(authRepositories: AuthRepositoryImpl): AuthRepository

    @Binds
    @AuthScope
    fun provideGetUserDataUseCase(getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCaseImpl): GetInfoAboutRegisterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    fun bindViewModel(authorizationViewModel: AuthorizationViewModel): ViewModel
}