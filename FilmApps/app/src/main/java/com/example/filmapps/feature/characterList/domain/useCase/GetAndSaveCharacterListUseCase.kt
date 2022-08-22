package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult

interface GetAndSaveCharacterListUseCase {
    suspend fun execute(page: Int, ignoreCache: Boolean = false): SaveCharacterListResult
}