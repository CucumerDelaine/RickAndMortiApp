package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.data.repository.CacheRepository
import com.example.filmapps.feature.characterList.data.repository.NetworkRepository
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListNetworkResponse
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import javax.inject.Inject

class GetAndSaveCharacterListUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository,
    private val networkRepository: NetworkRepository
) : GetAndSaveCharacterListUseCase {
    override suspend fun execute(page: Int, ignoreCache: Boolean): GetCharacterListResponse {
        if(ignoreCache){
           return when(val loadResult = networkRepository.getCharacterListNetwork(page)) {
                is GetCharacterListNetworkResponse.Success -> {
                    when (val saveResult = cacheRepository.saveCharacterList(loadResult.value)) {
                        is SaveCharacterListResult.Success -> cacheRepository.getCharacterList()
                        is SaveCharacterListResult.Error -> GetCharacterListResponse.Error(saveResult.message)
                    }
                }
                is GetCharacterListNetworkResponse.Error -> GetCharacterListResponse.Error(loadResult.message)
            }
        }
        return cacheRepository.getCharacterList()
    }
}