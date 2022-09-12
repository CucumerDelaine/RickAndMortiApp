package com.example.feature_characterlist_api.data.repository

import com.example.core_db_api.model.Character

interface NetworkRepository {
    suspend fun getCharacterListNetwork(page: Int): List<Character>
}