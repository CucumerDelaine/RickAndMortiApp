package com.example.filmapps.presentation.ui

import com.example.filmapps.data.model.ResultCharacterApi
import com.example.filmapps.presentation.model.UICharacterDetails

interface CharacterConverter {
    fun converter(values: ResultCharacterApi?): UICharacterDetails
}