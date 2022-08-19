package com.example.filmapps.feature.characterList.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.feature.characterList.di.scope.CharacterListScope
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import com.example.filmapps.feature.characterList.data.repository.CharacterListRepository
import com.example.filmapps.feature.characterList.data.repository.CharacterListRepositoryImpl
import com.example.filmapps.feature.characterList.domain.useCase.*
import com.example.filmapps.feature.characterList.data.model.CharacterListDatabaseModel
import com.example.filmapps.feature.characterList.data.model.CharacterListDatabaseModelImpl
import com.example.filmapps.feature.characterList.presentation.viewModel.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface CharacterListModule {

    @Binds
    @CharacterListScope
    fun provideCharacterListRepository(characterListRepository: CharacterListRepositoryImpl) : CharacterListRepository

    @Binds
    @CharacterListScope
    fun provideClearDatabaseUseCase(clearDatabaseUseCase: ClearDatabaseUseCaseImpl) : ClearDatabaseUseCase

    @Binds
    @CharacterListScope
    fun provideGetCharacterListUseCase(getCharacterListUseCase: GetCharacterListUseCaseImpl) : GetCharacterListUseCase

    @Binds
    @CharacterListScope
    fun provideLoadCharacterListUseCase(loadCharacterListUseCase: LoadCharacterListUseCaseImpl) : LoadCharacterListUseCase

    @Binds
    @CharacterListScope
    fun provideSaveCharacterListUseCase(saveCharacterListUseCase: SaveCharacterListUseCaseImpl) : SaveCharacterListUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    fun bindViewModel(characterListViewModel: CharacterListViewModel): ViewModel

    @Binds
    @CharacterListScope
    fun provideCharacterListModel(characterListModel: CharacterListDatabaseModelImpl) : CharacterListDatabaseModel

}