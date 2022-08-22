package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListNetworkResponse

interface NetworkRepository {
    suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse
}