package com.example.filmapps.presentation.ui

import com.example.filmapps.data.model.ResultCharacterApi
import com.example.filmapps.presentation.model.CharacterDetailsUIModel

interface ResultCharacterResponceModel {
    fun converter(values: ResultCharacterApi?): CharacterDetailsUIModel
}