package com.example.feature_characterlist_api.model

sealed class ClearDatabaseResult {
    object Success : ClearDatabaseResult()
    class Error(val message: Exception) : ClearDatabaseResult()
}
