package com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model

import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import java.lang.Exception

sealed class CharacterDetailsResponse {
    class Success(val value: Character?) : CharacterDetailsResponse()
    class Error(val message: Exception) : CharacterDetailsResponse()
}