package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.model

import android.content.Context
import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model.CharacterConverter
import javax.inject.Inject

class CharacterConverterImpl @Inject constructor(
    private val context: Context
) : CharacterConverter {
    val list: MutableList<Character> = ArrayList()
    override fun convert(values: ArrayList<Results>?): MutableList<Character> {
        val list: MutableList<Character> = ArrayList()
        if (values != null) {
            for (it in values) {
                list.add(
                    Character(
                        id = it.id,
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        gender = it.gender,
                        origin = it.origin?.name,
                        location = it.location?.name,
                        image = it.image
                    )
                )
            }
        }
        return list
    }
}
