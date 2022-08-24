package com.example.filmapps.feature.characterListAndDetails.details.data.repository

import com.example.filmapps.feature.characterListAndDetails.details.presentation.model.CharacterDetailsResponse

interface GetCharacterRepository {
    suspend fun getCharacter(id: Int): CharacterDetailsResponse
}