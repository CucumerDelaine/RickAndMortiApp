package com.example.filmapps.domain.useCase

import com.example.filmapps.presentation.model.CharacterListResponce

interface GetListCharacterUseCase {
    suspend fun execute(): CharacterListResponce
}