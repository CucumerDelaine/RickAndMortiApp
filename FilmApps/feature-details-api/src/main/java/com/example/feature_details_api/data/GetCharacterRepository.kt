package com.example.feature_details_api.data

import com.example.feature_details_api.model.CharacterDetailsResponse

interface GetCharacterRepository {
    suspend fun getCharacter(id: Int): CharacterDetailsResponse
}