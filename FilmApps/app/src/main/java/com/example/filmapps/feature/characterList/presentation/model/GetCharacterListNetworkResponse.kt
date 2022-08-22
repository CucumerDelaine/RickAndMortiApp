package com.example.filmapps.feature.characterList.presentation.model

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import java.lang.Exception

sealed class GetCharacterListNetworkResponse {
    class Success(val value: List<Character>?) : GetCharacterListNetworkResponse()
    class Error(val message: Exception) : GetCharacterListNetworkResponse()
}
