package com.example.filmapps.domain.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.data.repositories.UserRepositories
import com.example.filmapps.data.repositories.UserRepositoriesImpl
import com.example.filmapps.domain.di.components.RegistrationScope
import com.example.filmapps.domain.useCase.SaveUserDataUseCase
import com.example.filmapps.domain.useCase.SaveUserDataUseCaseImpl
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface RegistrationModule {

    @Binds
    @RegistrationScope
    fun provideUserRepositories(userRepositories: UserRepositoriesImpl) : UserRepositories

    @Binds
    @RegistrationScope
    fun provideSaveUserDataUseCase(saveUserDataUseCase: SaveUserDataUseCaseImpl) : SaveUserDataUseCase

    @Binds
    @IntoMap
    @ViewModelKey(SaveUserDataViewModel::class)
    fun bindViewModel(saveUserDataViewModel: SaveUserDataViewModel): ViewModel
}