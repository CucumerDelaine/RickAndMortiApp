package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.repository

import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model.CharacterConverter
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.retrofit.GetPageApi
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListNetworkResponse
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val retrofit: GetPageApi,
    private val characterConverter: CharacterConverter
) : NetworkRepository {
    override suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse {
        return try {
            GetCharacterListNetworkResponse.Success(characterConverter.convert(retrofit.getPage(page).results))
        } catch (e: Exception) {
            GetCharacterListNetworkResponse.Error(e)
        }
    }
}