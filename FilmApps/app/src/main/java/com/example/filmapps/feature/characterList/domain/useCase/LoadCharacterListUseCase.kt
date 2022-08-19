package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse

interface LoadCharacterListUseCase {
    suspend fun execute(page: Int): LoadCharacterListResponse
}