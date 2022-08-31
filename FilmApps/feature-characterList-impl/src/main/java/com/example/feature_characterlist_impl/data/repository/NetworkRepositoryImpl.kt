package com.example.feature_characterlist_impl.data.repository

import com.example.core_network_api.data.CoreNetworkRepository
import com.example.feature_characterlist_api.model.GetCharacterListNetworkResponse
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkRepository: CoreNetworkRepository,
    private val characterConverter: com.example.feature_characterlist_api.data.model.CharacterConverter
) : com.example.feature_characterlist_api.data.repository.NetworkRepository {
    override suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse {
        return try {
            GetCharacterListNetworkResponse.Success(
                characterConverter.convert(
                    networkRepository.getCharacterListNetwork(
                        page
                    )
                )
            )
        } catch (e: Exception) {
            GetCharacterListNetworkResponse.Error(e)
        }
    }
}