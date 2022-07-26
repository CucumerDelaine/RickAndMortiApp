package com.example.filmapps.domain.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel
import com.example.filmapps.presentation.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SaveUserDataViewModel::class)
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}