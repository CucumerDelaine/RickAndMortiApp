package com.example.filmapps.feature.characterListAndDetails.characterList.data.repository

import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.GetCharacterListNetworkResponse

interface NetworkRepository {
    suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse
}