package com.example.filmapps.feature.regAndAuth.registrations.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.presentation.viewModel.ViewModelKey
import com.example.filmapps.feature.regAndAuth.registrations.data.repository.SaveUserDataRepository
import com.example.filmapps.feature.regAndAuth.registrations.data.repository.SaveUserDataRepositoryImpl
import com.example.filmapps.feature.regAndAuth.registrations.di.scope.RegistrationScope
import com.example.filmapps.feature.regAndAuth.registrations.domain.useCase.SaveUserDataUseCase
import com.example.filmapps.feature.regAndAuth.registrations.domain.useCase.SaveUserDataUseCaseImpl
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface RegistrationModule {

    @Binds
    @RegistrationScope
    fun provideSaveDataUserRepositories(saveUserDataRepository: SaveUserDataRepositoryImpl) : SaveUserDataRepository

    @Binds
    @RegistrationScope
    fun provideSaveUserDataUseCase(saveUserDataUseCase: SaveUserDataUseCaseImpl) : SaveUserDataUseCase

    @Binds
    @IntoMap
    @ViewModelKey(SaveUserDataViewModel::class)
    fun bindViewModel(saveUserDataViewModel: SaveUserDataViewModel): ViewModel
}