package com.example.filmapps.featureCharDetailsApi.featureDetailsApi.presentation.model

import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsUIModel

interface ResultCharacterResponseModel {
    fun converter(values: Character?): CharacterDetailsUIModel
}