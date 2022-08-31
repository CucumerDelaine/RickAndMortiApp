package com.example.feature_characterlist_impl.data.repository

import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.model.Character
import com.example.feature_characterlist_api.model.ClearDatabaseResult
import com.example.feature_characterlist_api.model.GetCharacterListResponse
import com.example.feature_characterlist_api.model.SaveCharacterListResult
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : com.example.feature_characterlist_api.data.repository.CacheRepository {
    override suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult {
        return try {
            characterListRepository.save(characterList)
            SaveCharacterListResult.Success
        } catch (e: Exception) {
            SaveCharacterListResult.Error(e)
        }
    }

    override suspend fun getCharacterList(): GetCharacterListResponse {

        return try {
            GetCharacterListResponse.Success(characterListRepository.getAllCharacterList())
        } catch (e: Exception) {
            GetCharacterListResponse.Error(e)
        }
    }

    override suspend fun clearDatabase(): ClearDatabaseResult {
        return try {
            characterListRepository.delete()
            ClearDatabaseResult.Success
        } catch (e: Exception) {
            ClearDatabaseResult.Error(e)
        }
    }
}