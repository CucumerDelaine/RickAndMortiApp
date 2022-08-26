package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.ClearDatabaseResult
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.SaveCharacterListResult
import com.example.filmapps.featureCharacterListAndDetails.data.model.Character

interface CacheRepository {
    suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult
    suspend fun getCharacterList(): GetCharacterListResponse
    suspend fun clearDatabase(): ClearDatabaseResult
}