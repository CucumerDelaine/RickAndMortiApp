package com.example.filmapps.appApi.di

import androidx.lifecycle.ViewModelProvider
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}