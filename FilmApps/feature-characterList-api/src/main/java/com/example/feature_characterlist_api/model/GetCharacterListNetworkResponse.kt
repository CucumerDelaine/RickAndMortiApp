package com.example.feature_characterlist_api.model

import com.example.core_db_api.model.Character

sealed class GetCharacterListNetworkResponse {
    class Success(val value: List<Character>?) : GetCharacterListNetworkResponse()
    class Error(val message: Exception) : GetCharacterListNetworkResponse()
}
