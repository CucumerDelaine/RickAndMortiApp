package com.example.filmapps.feature.characterListAndDetails.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.ClearDatabaseResult

interface ClearDatabaseUseCase {
    suspend fun execute(): ClearDatabaseResult
}