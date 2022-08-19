package com.example.filmapps.feature.characterList.data.model

import android.content.Context
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import javax.inject.Inject

class CharacterListDatabaseModelImpl @Inject constructor(
    private val context: Context
) : CharacterListDatabaseModel {
    val list: MutableList<Character> = ArrayList()
    override fun converter(values: ArrayList<Results>?): MutableList<Character> {
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
