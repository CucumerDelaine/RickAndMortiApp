package com.example.feature_characterlist_impl.domain

import com.example.core_db_api.model.AppInfo
import com.example.feature_characterlist_api.data.repository.TimeAndPageInfoRepository
import com.example.feature_characterlist_api.domain.SaveAppInfoUseCase
import com.example.feature_characterlist_api.model.SaveAppInfoResult
import javax.inject.Inject

class SaveAppInfoUseCaseImpl @Inject constructor(
    private val timeAndPageInfoRepository: TimeAndPageInfoRepository
): SaveAppInfoUseCase {
    override suspend fun execute(info: AppInfo): SaveAppInfoResult {
        return try {
            timeAndPageInfoRepository.saveInfo(info)
            SaveAppInfoResult.Success
        }
        catch (e:Exception){
            SaveAppInfoResult.Error(e)
        }
    }
}