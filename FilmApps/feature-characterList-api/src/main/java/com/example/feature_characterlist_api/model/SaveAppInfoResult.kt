package com.example.feature_characterlist_api.model

sealed class SaveAppInfoResult {
    object Success : SaveAppInfoResult()
    class Error(val message: Exception) : SaveAppInfoResult()
}