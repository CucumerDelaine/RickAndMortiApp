package com.example.feature_characterlist_api.domain

import com.example.feature_characterlist_api.model.GetCharacterListResponse

interface GetAndSaveCharacterListUseCase {
    suspend fun execute(page: Int, ignoreCache: Boolean = false): GetCharacterListResponse
}