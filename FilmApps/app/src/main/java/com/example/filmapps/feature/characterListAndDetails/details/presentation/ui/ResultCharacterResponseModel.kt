package com.example.filmapps.feature.characterListAndDetails.details.presentation.ui

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterListAndDetails.details.presentation.model.CharacterDetailsUIModel

interface ResultCharacterResponseModel {
    fun converter(values: Character?): CharacterDetailsUIModel
}