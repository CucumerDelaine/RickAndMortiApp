package com.example.feature_characterlist_api.model

import com.example.core_db_api.model.AppInfo

sealed class GetAppInfoResult {
    class Success(val value: AppInfo) : GetAppInfoResult()
    class Error(val message: Exception) : GetAppInfoResult()
}