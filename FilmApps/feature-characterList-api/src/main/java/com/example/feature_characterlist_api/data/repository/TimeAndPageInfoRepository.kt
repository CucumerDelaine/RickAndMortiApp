package com.example.feature_characterlist_api.data.repository

import com.example.core_db_api.model.AppInfo

interface TimeAndPageInfoRepository {
    suspend fun saveInfo(info: AppInfo)
    suspend fun getInfo(id: Int = 0): AppInfo
}