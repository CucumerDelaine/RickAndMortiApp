package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult

interface SaveCharacterListUseCase {
    suspend fun execute(characterList: List<Character>?): SaveCharacterListResult
}