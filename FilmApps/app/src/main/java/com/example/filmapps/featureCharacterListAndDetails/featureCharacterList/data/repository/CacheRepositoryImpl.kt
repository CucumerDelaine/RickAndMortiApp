package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.repository

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.ClearDatabaseResult
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.SaveCharacterListResult
import com.example.filmapps.featureCharDetailsApi.data.bd.CharacterListDAO
import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.CacheRepository
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