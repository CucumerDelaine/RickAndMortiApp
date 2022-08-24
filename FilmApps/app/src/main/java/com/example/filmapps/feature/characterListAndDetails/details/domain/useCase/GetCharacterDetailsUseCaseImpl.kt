package com.example.filmapps.feature.characterListAndDetails.details.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.details.data.repository.GetCharacterRepository
import com.example.filmapps.feature.characterListAndDetails.details.presentation.model.CharacterDetailsResponse
import javax.inject.Inject

class GetCharacterDetailsUseCaseImpl @Inject constructor(
    private val getCharacterRepository: GetCharacterRepository
) : GetCharacterDetailsUseCase {
    override suspend fun execute(id: Int): CharacterDetailsResponse {
        return getCharacterRepository.getCharacter(id)
    }
}