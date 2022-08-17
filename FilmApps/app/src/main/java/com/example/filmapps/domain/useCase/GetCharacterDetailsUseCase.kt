package com.example.filmapps.domain.useCase

import com.example.filmapps.presentation.model.CharacterDetailsResponce

interface GetCharacterDetailsUseCase {
    suspend fun execute(id: String): CharacterDetailsResponce
}