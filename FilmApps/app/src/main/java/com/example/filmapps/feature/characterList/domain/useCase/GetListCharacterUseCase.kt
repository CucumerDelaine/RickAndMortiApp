package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.presentation.model.CharacterListResponce

interface GetListCharacterUseCase {
    suspend fun execute(): CharacterListResponce
}