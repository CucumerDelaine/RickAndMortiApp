package com.example.filmapps.domain.useCase

import com.example.filmapps.presentation.model.Request

interface GetListCharacterUseCase {
    suspend fun execute(): Request
}