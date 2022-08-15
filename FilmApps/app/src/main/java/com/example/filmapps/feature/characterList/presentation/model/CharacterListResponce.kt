package com.example.filmapps.feature.characterList.presentation.model

import com.example.filmapps.feature.characterList.data.model.DataApi
import java.lang.Exception

sealed class CharacterListResponce {
    class Success(val value: DataApi?) : CharacterListResponce()
    class Error(val message: Exception) : CharacterListResponce()
    object Loading : CharacterListResponce()
    object Finally : CharacterListResponce()
}
