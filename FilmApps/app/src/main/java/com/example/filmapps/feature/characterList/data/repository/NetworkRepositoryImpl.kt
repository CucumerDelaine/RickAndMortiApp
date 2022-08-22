package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterList.data.model.CharacterConverter
import com.example.filmapps.feature.characterList.data.retrofit.GetPageApi
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListNetworkResponse
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val retrofit: GetPageApi,
    private val characterConverter: CharacterConverter
) :NetworkRepository {
    override suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse {
        return try {
            GetCharacterListNetworkResponse.Success(characterConverter.convert(retrofit.getPage(page).results))
        } catch (e: Exception) {
            GetCharacterListNetworkResponse.Error(e)
        }
    }
}