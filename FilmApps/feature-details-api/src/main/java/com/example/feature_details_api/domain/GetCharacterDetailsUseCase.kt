package com.example.feature_details_api.domain

import com.example.feature_details_api.model.CharacterDetailsResponse

interface GetCharacterDetailsUseCase {
    suspend fun execute(id: Int): CharacterDetailsResponse
}