package com.example.core.viewModel

import androidx.lifecycle.ViewModelProvider
import com.example.core.ui.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}