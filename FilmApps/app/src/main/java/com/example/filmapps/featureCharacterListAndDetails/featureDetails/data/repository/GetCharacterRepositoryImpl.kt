package com.example.filmapps.featureCharacterListAndDetails.featureDetails.data.repository

import com.example.filmapps.featureCharDetailsApi.data.bd.CharacterListDAO
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResponse
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.data.repository.GetCharacterRepository
import java.lang.Exception
import javax.inject.Inject

class GetCharacterRepositoryImpl @Inject constructor(
    private val characterListDao: CharacterListDAO
) : GetCharacterRepository {
    override suspend fun getCharacter(id: Int): CharacterDetailsResponse {
        return try {
            CharacterDetailsResponse.Success(characterListDao.getById(id))
        } catch (e: Exception) {
            CharacterDetailsResponse.Error(e)
        }
    }
}