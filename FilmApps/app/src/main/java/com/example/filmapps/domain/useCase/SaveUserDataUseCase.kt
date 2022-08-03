package com.example.filmapps.domain.useCase

import com.example.filmapps.Result
import com.example.filmapps.domain.model.UserDataParam

interface SaveUserDataUseCase {
    suspend fun execute(param: UserDataParam): Result
}