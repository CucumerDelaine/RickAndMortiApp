package com.example.filmapps.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.data.repository.RetrofitRepository
import com.example.filmapps.data.repository.RetrofitRepositoryImpl
import com.example.filmapps.di.scope.CharacterListScope
import com.example.filmapps.domain.useCase.GetListCharacterUseCase
import com.example.filmapps.domain.useCase.GetListCharacterUseCaseImpl
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import com.example.filmapps.presentation.viewModel.ListCharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface FilmListModule {

    @Binds
    @CharacterListScope
    fun provideRetrofitRepositories(retrofitRepository: RetrofitRepositoryImpl) : RetrofitRepository

    @Binds
    @CharacterListScope
    fun provideGetListCharacterUseCase(getListCharacterUseCase: GetListCharacterUseCaseImpl) : GetListCharacterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(ListCharacterViewModel::class)
    fun bindViewModel(listCharacterViewModel: ListCharacterViewModel): ViewModel
}