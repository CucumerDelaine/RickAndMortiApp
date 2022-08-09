package com.example.filmapps.domain.di.components

import com.example.filmapps.domain.di.module.FilmListModule
import com.example.filmapps.domain.di.module.RetrofitModule
import com.example.filmapps.domain.di.scope.CharacterListScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component

@Component(modules = [FilmListModule::class, RetrofitModule::class], dependencies = [AppComponent::class])
@CharacterListScope
interface FilmListComponent{
    fun viewModelsFactory(): ViewModelFactory
}
