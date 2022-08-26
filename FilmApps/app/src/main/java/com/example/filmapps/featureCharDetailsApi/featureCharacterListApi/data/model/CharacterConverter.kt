package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.model.Results
import com.example.filmapps.featureCharacterListAndDetails.data.model.Character

interface CharacterConverter {
    fun convert(values: ArrayList<Results>?): MutableList<Character>
}