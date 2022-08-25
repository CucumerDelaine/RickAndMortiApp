package com.example.filmapps.feature.characterListAndDetails.characterList.presentation.model

import java.lang.Exception

sealed class SaveCharacterListResult {
    object Success : SaveCharacterListResult()
    class Error(val message: Exception) : SaveCharacterListResult()
}
