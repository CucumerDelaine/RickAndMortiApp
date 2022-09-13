package com.example.feature_characterlist_impl.data.repository

import com.example.core_db_api.data.AppInfoRepository
import com.example.core_db_api.model.AppInfo
import com.example.feature_characterlist_api.data.repository.TimeAndPageInfoRepository
import javax.inject.Inject

class TimeAndPageInfoRepositoryImpl @Inject constructor(
    private val appInfoRepository: AppInfoRepository
) : TimeAndPageInfoRepository {
    override suspend fun saveInfo(info: AppInfo) {
        appInfoRepository.saveInfo(info)
    }

    override suspend fun getInfo(id: Int): AppInfo {
        return appInfoRepository.getInfoById(id)
    }
}