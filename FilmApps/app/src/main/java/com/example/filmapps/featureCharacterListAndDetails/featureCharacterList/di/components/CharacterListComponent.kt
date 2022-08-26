package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.components

import com.example.filmapps.app.di.components.AppComponent
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.module.CharacterListModule
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.module.CharacterListNetwork
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.scope.CharacterListScope
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import dagger.Component

@Component(
    modules = [CharacterListModule::class, CharacterListNetwork::class],
    dependencies = [AppComponent::class]
)
@CharacterListScope
interface CharacterListComponent {
    fun viewModelsFactory(): ViewModelFactory
}
