package com.example.feature_characterlist_impl.data.repository

import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.model.Character
import com.example.feature_characterlist_api.data.repository.CacheRepository
import com.example.feature_characterlist_api.model.ClearDatabaseResult
import com.example.feature_characterlist_api.model.GetCharacterListResponse
import com.example.feature_characterlist_api.model.SaveCharacterListResult
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : CacheRepository {
    override suspend fun saveCharacterList(characterList: List<Character>?) {
        characterListRepository.save(characterList)
    }

    override suspend fun getCharacterList(): List<Character?> {
        return characterListRepository.getAllCharacterList()
    }

    override suspend fun clearDatabase() {
        return characterListRepository.delete()
    }
}