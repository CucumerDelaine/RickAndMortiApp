package com.example.feature_characterlist_api.data.repository

import com.example.core_db_api.model.Character
import com.example.feature_characterlist_api.model.ClearDatabaseResult
import com.example.feature_characterlist_api.model.GetCharacterListResponse
import com.example.feature_characterlist_api.model.SaveCharacterListResult

interface CacheRepository {
    suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult
    suspend fun getCharacterList(): GetCharacterListResponse
    suspend fun clearDatabase(): ClearDatabaseResult
}