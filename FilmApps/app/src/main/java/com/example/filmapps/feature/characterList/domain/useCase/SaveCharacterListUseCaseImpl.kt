package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.data.repository.CharacterListRepository
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import javax.inject.Inject

class SaveCharacterListUseCaseImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : SaveCharacterListUseCase {
    override suspend fun execute(characterList: List<Character>?): SaveCharacterListResult {
        return characterListRepository.saveCharacterList(characterList)
    }
}