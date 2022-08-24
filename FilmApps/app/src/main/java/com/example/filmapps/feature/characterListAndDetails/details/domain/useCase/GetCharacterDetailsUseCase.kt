package com.example.filmapps.feature.characterListAndDetails.details.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.details.presentation.model.CharacterDetailsResponse

interface GetCharacterDetailsUseCase {
    suspend fun execute(id: Int): CharacterDetailsResponse
}