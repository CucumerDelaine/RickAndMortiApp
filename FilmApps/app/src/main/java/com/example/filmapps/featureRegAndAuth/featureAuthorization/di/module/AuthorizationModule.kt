package com.example.filmapps.featureRegAndAuth.featureAuthorization.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.scope.AuthorizationScope
import com.example.filmapps.featureRegAndAuth.featureAuthorization.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.featureRegAndAuth.featureAuthorization.domain.useCase.GetInfoAboutRegisterUseCaseImpl
import com.example.filmapps.featureRegAndAuth.featureAuthorization.presentation.viewModel.AuthorizationViewModel
import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import com.example.filmapps.featureRegAndAuth.data.repositories.UserRepositoriesImpl
import com.example.filmapps.appApi.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface AuthorizationModule {

    @Binds
    @AuthorizationScope
    fun provideUserRepositories(userRepositories: UserRepositoriesImpl) : UserRepositories

    @Binds
    @AuthorizationScope
    fun provideGetUserDataUseCase(getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCaseImpl) : GetInfoAboutRegisterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    fun bindViewModel(authorizationViewModel: AuthorizationViewModel): ViewModel
}