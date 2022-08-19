package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.data.repository.CharacterListRepository
import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse
import javax.inject.Inject

class LoadCharacterListUseCaseImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : LoadCharacterListUseCase {
    override suspend fun execute(page: Int): LoadCharacterListResponse {
        return characterListRepository.loadCharacterList(page)
    }
}