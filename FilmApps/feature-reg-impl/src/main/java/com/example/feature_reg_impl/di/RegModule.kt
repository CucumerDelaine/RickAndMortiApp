package com.example.feature_reg_impl.di

import androidx.lifecycle.ViewModel
import com.example.core.viewModel.ViewModelKey
import com.example.feature_reg_api.data.RegRepository
import com.example.feature_reg_api.domain.SaveUserDataUseCase
import com.example.feature_reg_impl.data.RegRepositoryImpl
import com.example.feature_reg_impl.domain.SaveUserDataUseCaseImpl
import com.example.feature_reg_impl.presentation.viewModel.SaveUserDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RegModule {
    @Binds
    @RegScope
    fun provideUserRepositories(regRepositories: RegRepositoryImpl): RegRepository

    @Binds
    @RegScope
    fun provideSaveUserDataUseCase(saveUserDataUseCase: SaveUserDataUseCaseImpl): SaveUserDataUseCase

    @Binds
    @IntoMap
    @ViewModelKey(SaveUserDataViewModel::class)
    fun bindViewModel(saveUserDataViewModel: SaveUserDataViewModel): ViewModel
}