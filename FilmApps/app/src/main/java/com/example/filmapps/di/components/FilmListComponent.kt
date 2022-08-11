package com.example.filmapps.di.components

import com.example.filmapps.di.module.FilmListModule
import com.example.filmapps.di.module.CharacterListNetwork
import com.example.filmapps.di.scope.CharacterListScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component

@Component(modules = [FilmListModule::class, CharacterListNetwork::class], dependencies = [AppComponent::class])
@CharacterListScope
interface FilmListComponent{
    fun viewModelsFactory(): ViewModelFactory
}
