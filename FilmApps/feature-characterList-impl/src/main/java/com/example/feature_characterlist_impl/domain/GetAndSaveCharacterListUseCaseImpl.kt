package com.example.feature_characterlist_impl.domain

import com.example.feature_characterlist_api.data.repository.CacheRepository
import com.example.feature_characterlist_api.data.repository.NetworkRepository
import com.example.feature_characterlist_api.domain.GetAndSaveCharacterListUseCase
import com.example.feature_characterlist_api.model.GetCharacterListNetworkResponse
import com.example.feature_characterlist_api.model.GetCharacterListResponse
import com.example.feature_characterlist_api.model.SaveCharacterListResult
import javax.inject.Inject

class GetAndSaveCharacterListUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository,
    private val networkRepository: NetworkRepository
) : GetAndSaveCharacterListUseCase {
    override suspend fun execute(page: Int, ignoreCache: Boolean): GetCharacterListResponse {
        if (ignoreCache) {
            return when (val loadResult = networkRepository.getCharacterListNetwork(page)) {
                is GetCharacterListNetworkResponse.Success -> {
                    when (val saveResult = cacheRepository.saveCharacterList(loadResult.value)) {
                        is SaveCharacterListResult.Success -> cacheRepository.getCharacterList()
                        is SaveCharacterListResult.Error -> GetCharacterListResponse.Error(
                            saveResult.message
                        )
                    }
                }
                is GetCharacterListNetworkResponse.Error -> GetCharacterListResponse.Error(
                    loadResult.message
                )
            }
        }
        return cacheRepository.getCharacterList()
    }
}