package com.example.filmapps.domain.useCase

import com.example.filmapps.data.repository.GetCharacterRepository
import com.example.filmapps.presentation.model.CharacterDetailsResponce
import javax.inject.Inject

class GetCharacterDetailsUseCaseImpl @Inject constructor(
    private val getCharacterRepository: GetCharacterRepository
) : GetCharacterDetailsUseCase {
    override suspend fun execute(id: String): CharacterDetailsResponce {
        return getCharacterRepository.loadCharacter(id)
    }
}