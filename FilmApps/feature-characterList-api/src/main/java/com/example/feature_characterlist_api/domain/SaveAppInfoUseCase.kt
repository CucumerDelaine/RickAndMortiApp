package com.example.feature_characterlist_api.domain

import com.example.core_db_api.model.AppInfo
import com.example.feature_characterlist_api.model.SaveAppInfoResult

interface SaveAppInfoUseCase {
    suspend fun execute(info: AppInfo): SaveAppInfoResult
}