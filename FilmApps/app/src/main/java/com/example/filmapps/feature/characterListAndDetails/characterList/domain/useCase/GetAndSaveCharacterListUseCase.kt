package com.example.filmapps.feature.characterListAndDetails.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.GetCharacterListResponse

interface GetAndSaveCharacterListUseCase {
    suspend fun execute(page: Int, ignoreCache: Boolean = false): GetCharacterListResponse
}