package com.example.filmapps.feature.characterListAndDetails.details.presentation.model

sealed class CharacterDetailsResult {
    class Success(val value: CharacterDetailsUIModel?) : CharacterDetailsResult()
    class Error(val message: String) : CharacterDetailsResult()
    object Loading : CharacterDetailsResult()
}