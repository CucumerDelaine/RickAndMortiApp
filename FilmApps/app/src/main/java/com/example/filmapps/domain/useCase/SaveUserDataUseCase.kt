package com.example.filmapps.domain.useCase

import com.example.filmapps.domain.model.SaveUserDataParam

interface SaveUserDataUseCase {
    fun execute(param: SaveUserDataParam): Boolean
}