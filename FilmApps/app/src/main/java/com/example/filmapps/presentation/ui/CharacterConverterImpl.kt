package com.example.filmapps.presentation.ui

import android.content.Context
import com.example.filmapps.R
import com.example.filmapps.data.model.ResultCharacterApi
import com.example.filmapps.presentation.model.UICharacterDetails
import javax.inject.Inject

internal class CharacterConverterImpl @Inject constructor(
    private val context: Context
): CharacterConverter {
    override fun converter(values: ResultCharacterApi?): UICharacterDetails = UICharacterDetails(
        "${context.getString(R.string.name)} ${values?.name}",
        "${context.getString(R.string.status)} ${values?.status}",
        "${context.getString(R.string.species)} ${values?.species}",
        "${context.getString(R.string.gender)} ${values?.gender}",
        "${context.getString(R.string.origin)} ${values?.origin?.name}",
        "${context.getString(R.string.location)} ${values?.location?.name}",
        values?.image
    )
}