package com.example.feature_characterlist_api.data.repository

import com.example.feature_characterlist_api.model.GetCharacterListNetworkResponse

interface NetworkRepository {
    suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse
}