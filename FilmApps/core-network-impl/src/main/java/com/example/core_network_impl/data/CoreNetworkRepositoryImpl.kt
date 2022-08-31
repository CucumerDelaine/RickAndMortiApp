package com.example.core_network_impl.data

import com.example.core_network_api.data.CoreNetworkRepository
import com.example.core_network_api.model.NetworkCharacter
import javax.inject.Inject

class CoreNetworkRepositoryImpl @Inject constructor(
    private val retrofit: GetPageApi
) : CoreNetworkRepository {
    override suspend fun getCharacterListNetwork(page: Int): MutableList<NetworkCharacter> {
        val list: MutableList<NetworkCharacter> = ArrayList()
        val result = retrofit.getPage(page).results
        for (it in result) {
            list.add(
                NetworkCharacter(
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
        return list
    }
}