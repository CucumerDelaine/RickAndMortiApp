package com.example.feature_characterlist_api.domain

import com.example.feature_characterlist_api.model.ClearDatabaseResult

interface ClearDatabaseUseCase {
    suspend fun execute(): ClearDatabaseResult
}