package com.example.filmapps.domain.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.Presentation.viewModel.AuthorizationViewModel
import com.example.filmapps.data.repositories.UserRepositories
import com.example.filmapps.data.repositories.UserRepositoriesImpl
import com.example.filmapps.domain.UseCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.domain.UseCase.GetInfoAboutRegisterUseCaseImpl
import com.example.filmapps.domain.di.components.AuthorizationScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface AuthorizationModule {

    @Binds
    @AuthorizationScope
    fun provideUserRepositories(userRepositories: UserRepositoriesImpl) : UserRepositories

    @Binds
    fun provideGetUserDataUseCase(getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCaseImpl) : GetInfoAboutRegisterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    fun bindViewModel(authorizationViewModel: AuthorizationViewModel): ViewModel
}