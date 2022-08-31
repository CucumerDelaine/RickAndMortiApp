package com.example.feature_details_impl.presentation.model

import android.content.Context
import com.example.core_db_api.model.Character
import com.example.feature_details_api.model.CharacterDetailsUIModel
import com.example.feature_details_api.model.ResultCharacterResponseModel
import com.example.feature_details_impl.R
import javax.inject.Inject

class ResultCharacterResponseModelImpl @Inject constructor(
    private val context: Context
) : ResultCharacterResponseModel {
    override fun converter(values: Character?): CharacterDetailsUIModel = CharacterDetailsUIModel(
        "${context.getString(R.string.name)} ${values?.name}",
        "${context.getString(R.string.status)} ${values?.status}",
        "${context.getString(R.string.species)} ${values?.species}",
        "${context.getString(R.string.gender)} ${values?.gender}",
        "${context.getString(R.string.origin)} ${values?.origin}",
        "${context.getString(R.string.location)} ${values?.location}",
        values?.image,
        values?.name
    )
}