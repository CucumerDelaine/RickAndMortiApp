package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model

import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import java.lang.Exception

sealed class CharacterListResult {
    class Success(val value: List<Character>?) : CharacterListResult()
    class Error(val message: Exception) : CharacterListResult()
    object Loading : CharacterListResult()
    object Finally : CharacterListResult()
}
