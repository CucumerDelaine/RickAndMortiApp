package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model


import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import java.lang.Exception

sealed class GetCharacterListResponse {
    class Success(val value: List<Character>?) : GetCharacterListResponse()
    class Error(val message: Exception) : GetCharacterListResponse()
}
