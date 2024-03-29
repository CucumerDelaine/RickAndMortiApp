package com.example.feature_characterlist_api.model

import com.example.core_db_api.model.Character


sealed class GetCharacterListResponse {
    class Success(val value: List<Character?>) : GetCharacterListResponse()
    class Error(val message: Exception) : GetCharacterListResponse()
}
