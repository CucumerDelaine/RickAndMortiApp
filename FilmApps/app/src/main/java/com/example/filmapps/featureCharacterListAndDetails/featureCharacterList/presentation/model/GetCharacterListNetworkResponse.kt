package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model

import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import java.lang.Exception

sealed class GetCharacterListNetworkResponse {
    class Success(val value: List<Character>?) : GetCharacterListNetworkResponse()
    class Error(val message: Exception) : GetCharacterListNetworkResponse()
}
