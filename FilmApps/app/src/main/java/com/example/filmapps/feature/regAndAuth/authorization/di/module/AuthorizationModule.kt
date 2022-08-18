package com.example.filmapps.feature.regAndAuth.authorization.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.feature.regAndAuth.authorization.data.repository.IsUserRegisteredRepository
import com.example.filmapps.feature.regAndAuth.authorization.data.repository.IsUserRegisteredRepositoryImpl
import com.example.filmapps.feature.regAndAuth.authorization.di.scope.AuthorizationScope
import com.example.filmapps.feature.regAndAuth.authorization.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.feature.regAndAuth.authorization.domain.useCase.GetInfoAboutRegisterUseCaseImpl
import com.example.filmapps.feature.regAndAuth.authorization.presentation.viewModel.AuthorizationViewModel
import com.example.filmapps.presentation.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface AuthorizationModule {

    @Binds
    @AuthorizationScope
    fun provideIsUserRegisteredRepositories(isUserRegisteredRepository: IsUserRegisteredRepositoryImpl) : IsUserRegisteredRepository

    @Binds
    @AuthorizationScope
    fun provideGetUserDataUseCase(getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCaseImpl) : GetInfoAboutRegisterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    fun bindViewModel(authorizationViewModel: AuthorizationViewModel): ViewModel
}