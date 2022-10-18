package com.example.feature_characterlist_api.domain

import com.example.feature_characterlist_api.model.GetAppInfoResult

interface GetAppInfoUseCase {
    suspend fun execute(): GetAppInfoResult
}