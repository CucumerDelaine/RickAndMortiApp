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
        return try {
            if (ignoreCache) {
                val loadResult = networkRepository.getCharacterListNetwork(page)
                cacheRepository.saveCharacterList(loadResult)
                GetCharacterListResponse.Success(cacheRepository.getCharacterList())
            } else
                GetCharacterListResponse.Success(cacheRepository.getCharacterList())
        } catch (e: Exception) {
            GetCharacterListResponse.Error(e)
        }
    }
}