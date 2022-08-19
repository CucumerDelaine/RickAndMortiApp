package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.data.repository.CharacterListRepository
import javax.inject.Inject

class ClearDatabaseUseCaseImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : ClearDatabaseUseCase {
    override suspend fun execute(characterList: List<Character>?) {
        characterListRepository.clearDatabase(characterList)
    }
}