package com.example.feature_details_api.model

import com.example.core_db_api.model.Character


interface ResultCharacterResponseModel {
    fun converter(values: Character?): CharacterDetailsUIModel
}