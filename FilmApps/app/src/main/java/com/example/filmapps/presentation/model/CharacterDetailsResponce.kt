package com.example.filmapps.presentation.model

import com.example.filmapps.data.model.ResultCharacterApi
import java.lang.Exception

sealed class CharacterDetailsResponce {
    class Success(val value: ResultCharacterApi?) : CharacterDetailsResponce()
    class Error(val message: Exception) : CharacterDetailsResponce()
    object Loading : CharacterDetailsResponce()
}