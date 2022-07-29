package com.example.filmapps.domain.useCase

import com.example.filmapps.domain.model.UserDataParam

interface SaveUserDataUseCase {
    fun execute(param: UserDataParam): Boolean
}