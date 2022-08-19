package com.example.filmapps.feature.characterList.presentation.model

import com.example.filmapps.feature.characterList.data.model.DataApi
import java.lang.Exception

sealed class LoadCharacterListResponse {
    class Success(val value: DataApi?) : LoadCharacterListResponse()
    class Error(val message: Exception) : LoadCharacterListResponse()
}
