package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.presentation.model.ClearDatabaseResult
import com.example.filmapps.feature.characterListAndDetails.data.model.Character

interface ClearDatabaseUseCase {
    suspend fun execute(): ClearDatabaseResult
}