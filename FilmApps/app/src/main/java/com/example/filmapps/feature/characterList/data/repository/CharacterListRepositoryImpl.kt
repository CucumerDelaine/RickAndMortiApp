package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterListAndDetails.data.bd.CharacterListDAO
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.data.retrofit.GetPageApi
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import javax.inject.Inject
import kotlin.Exception

class CharacterListRepositoryImpl @Inject constructor(
    private val retrofit: GetPageApi,
    private val characterListDao: CharacterListDAO
) : CharacterListRepository {
    override suspend fun loadCharacterList(page: Int): LoadCharacterListResponse {
        return try {
            LoadCharacterListResponse.Success(retrofit.getPage(page))
        } catch (e: Exception) {
            LoadCharacterListResponse.Error(e)
        }
    }

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

    override suspend fun clearDatabase(characterList: List<Character>?) {
        characterListDao.delete(characterList)
    }
}