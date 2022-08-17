package com.example.filmapps.presentation.ui

import android.content.Context
import com.example.filmapps.R
import com.example.filmapps.data.model.ResultCharacterApi
import com.example.filmapps.presentation.model.CharacterDetailsUIModel
import javax.inject.Inject

internal class ResultCharacterResponceModelImpl @Inject constructor(
    private val context: Context
): ResultCharacterResponceModel {
    override fun converter(values: ResultCharacterApi?): CharacterDetailsUIModel = CharacterDetailsUIModel(
        "${context.getString(R.string.name)} ${values?.name}",
        "${context.getString(R.string.status)} ${values?.status}",
        "${context.getString(R.string.species)} ${values?.species}",
        "${context.getString(R.string.gender)} ${values?.gender}",
        "${context.getString(R.string.origin)} ${values?.origin?.name}",
        "${context.getString(R.string.location)} ${values?.location?.name}",
        values?.image
    )
}