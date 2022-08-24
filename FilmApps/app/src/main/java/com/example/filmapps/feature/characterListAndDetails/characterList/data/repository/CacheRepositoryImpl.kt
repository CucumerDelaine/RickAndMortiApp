package com.example.filmapps.feature.characterListAndDetails.characterList.data.repository

import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.ClearDatabaseResult
import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.SaveCharacterListResult
import com.example.filmapps.feature.characterListAndDetails.data.bd.CharacterListDAO
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val characterListDao: CharacterListDAO
): CacheRepository {
    override suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult {
        return try {
            characterListDao.insert(characterList)
            SaveCharacterListResult.Success
        }
        catch (e: Exception) {
            SaveCharacterListResult.Error(e)
        }
    }

    override suspend fun getCharacterList(): GetCharacterListResponse {

        return try {
            GetCharacterListResponse.Success(characterListDao.getAll())
        }
        catch (e: Exception) {
            GetCharacterListResponse.Error(e)
        }
    }

    override suspend fun clearDatabase(): ClearDatabaseResult {
        return try {
            characterListDao.delete(characterListDao.getAll())
            ClearDatabaseResult.Success
        }
        catch (e: Exception) {
            ClearDatabaseResult.Error(e)
        }
    }
}