package com.example.feature_characterlist_impl.domain

import com.example.feature_characterlist_api.data.repository.CacheRepository
import com.example.feature_characterlist_api.domain.ClearDatabaseUseCase
import com.example.feature_characterlist_api.model.ClearDatabaseResult
import javax.inject.Inject

class ClearDatabaseUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository
) : ClearDatabaseUseCase {
    override suspend fun execute(): ClearDatabaseResult {
        return try {
            cacheRepository.clearDatabase()
            ClearDatabaseResult.Success
        } catch (e: Exception) {
            ClearDatabaseResult.Error(e)
        }
    }
}