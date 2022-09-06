package com.example.feature_characterlist_api.model

sealed class SaveCharacterListResult {
    object Success : SaveCharacterListResult()
    class Error(val message: Exception) : SaveCharacterListResult()
}
