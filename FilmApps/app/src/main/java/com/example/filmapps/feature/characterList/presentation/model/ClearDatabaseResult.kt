package com.example.filmapps.feature.characterList.presentation.model

import java.lang.Exception

sealed class ClearDatabaseResult {
    object Success : ClearDatabaseResult()
    class Error(val message: Exception) : ClearDatabaseResult()
}
