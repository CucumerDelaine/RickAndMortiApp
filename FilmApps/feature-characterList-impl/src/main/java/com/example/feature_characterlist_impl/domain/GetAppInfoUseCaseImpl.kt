package com.example.feature_characterlist_impl.domain

import com.example.feature_characterlist_api.data.repository.TimeAndPageInfoRepository
import com.example.feature_characterlist_api.domain.GetAppInfoUseCase
import com.example.feature_characterlist_api.model.GetAppInfoResult
import javax.inject.Inject

class GetAppInfoUseCaseImpl @Inject constructor(
    private val timeAndPageInfoRepository: TimeAndPageInfoRepository
) : GetAppInfoUseCase {
    override suspend fun execute(): GetAppInfoResult {
        return try {
            GetAppInfoResult.Success(timeAndPageInfoRepository.getInfo())
        } catch (e: Exception) {
            GetAppInfoResult.Error(e)
        }
    }
}