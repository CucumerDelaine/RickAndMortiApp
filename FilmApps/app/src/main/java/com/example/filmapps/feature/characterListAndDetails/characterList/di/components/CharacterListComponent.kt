package com.example.filmapps.feature.characterListAndDetails.characterList.di.components

import com.example.filmapps.di.components.AppComponent
import com.example.filmapps.feature.characterListAndDetails.characterList.di.module.CharacterListModule
import com.example.filmapps.feature.characterListAndDetails.characterList.di.module.CharacterListNetwork
import com.example.filmapps.feature.characterListAndDetails.characterList.di.scope.CharacterListScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component

@Component(
    modules = [CharacterListModule::class, CharacterListNetwork::class],
    dependencies = [AppComponent::class]
)
@CharacterListScope
interface CharacterListComponent {
    fun viewModelsFactory(): ViewModelFactory
}
