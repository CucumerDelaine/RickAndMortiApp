package com.example.filmapps.feature.characterListAndDetails.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.characterList.data.repository.CacheRepository
import com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model.ClearDatabaseResult
import javax.inject.Inject

class ClearDatabaseUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository
) : ClearDatabaseUseCase {
    override suspend fun execute(): ClearDatabaseResult {
       return cacheRepository.clearDatabase()
    }
}