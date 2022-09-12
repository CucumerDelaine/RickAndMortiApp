package com.example.feature_details_impl.domain

import com.example.feature_details_api.data.GetCharacterRepository
import com.example.feature_details_api.domain.GetCharacterDetailsUseCase
import com.example.feature_details_api.model.CharacterDetailsResponse
import javax.inject.Inject

class GetCharacterDetailsUseCaseImpl @Inject constructor(
    private val getCharacterRepository: GetCharacterRepository
) : GetCharacterDetailsUseCase {
    override suspend fun execute(id: Int): CharacterDetailsResponse {
        return try {
            CharacterDetailsResponse.Success(getCharacterRepository.getCharacter(id))
        } catch (e: Exception) {
            CharacterDetailsResponse.Error(e)
        }
    }
}