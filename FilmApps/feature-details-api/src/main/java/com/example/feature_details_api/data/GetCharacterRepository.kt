package com.example.feature_details_api.data

import com.example.core_db_api.model.Character

interface GetCharacterRepository {
    suspend fun getCharacter(id: Int): Character
}