package com.example.core_network_api.data

import com.example.core_network_api.model.NetworkCharacter

interface CoreNetworkRepository {
    suspend fun getCharacterListNetwork(page: Int): MutableList<NetworkCharacter>
}