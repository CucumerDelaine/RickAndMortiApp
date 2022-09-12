package com.example.feature_characterlist_impl.data.repository

import com.example.core_db_api.model.Character
import com.example.core_network_api.data.CoreNetworkRepository
import com.example.feature_characterlist_api.data.model.CharacterConverter
import com.example.feature_characterlist_api.data.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkRepository: CoreNetworkRepository,
    private val characterConverter: CharacterConverter
) : NetworkRepository {
    override suspend fun getCharacterListNetwork(page: Int): List<Character> {
        return characterConverter.convert(
            networkRepository.getCharacterListNetwork(
                page
            )
        )
    }
}