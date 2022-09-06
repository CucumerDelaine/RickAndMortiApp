package com.example.feature_details_impl.data

import com.example.core_db_api.data.CharacterListRepository
import com.example.feature_details_api.data.GetCharacterRepository
import com.example.feature_details_api.model.CharacterDetailsResponse
import javax.inject.Inject

class GetCharacterRepositoryImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : GetCharacterRepository {
    override suspend fun getCharacter(id: Int): CharacterDetailsResponse {
        return try {
            CharacterDetailsResponse.Success(characterListRepository.getCharacterById(id))
        } catch (e: Exception) {
            CharacterDetailsResponse.Error(e)
        }
    }
}