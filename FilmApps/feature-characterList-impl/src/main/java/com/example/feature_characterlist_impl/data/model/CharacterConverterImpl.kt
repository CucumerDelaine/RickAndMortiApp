package com.example.feature_characterlist_impl.data.model

import com.example.core_db_api.model.Character
import com.example.core_network_api.model.NetworkCharacter
import com.example.feature_characterlist_api.data.model.CharacterConverter
import javax.inject.Inject

class CharacterConverterImpl @Inject constructor() :
    CharacterConverter {
    override fun convert(values: MutableList<NetworkCharacter>): MutableList<Character> {
        val list = values.map { Character(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    species = it.species,
                    gender = it.gender,
                    origin = it.origin,
                    location = it.location,
                    image = it.image
                ) } as MutableList
        return list
    }
}
