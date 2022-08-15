package com.example.filmapps.presentation.model

sealed class CharacterDetails {
    class Success(val value: ConvertCharacterDetails?) : CharacterDetails()
    class Error(val message: String) : CharacterDetails()
    object Loading : CharacterDetails()
}