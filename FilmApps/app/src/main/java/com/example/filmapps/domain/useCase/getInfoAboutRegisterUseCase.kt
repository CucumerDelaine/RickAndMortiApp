package com.example.filmapps.domain.UseCase

import com.example.filmapps.Result
import com.example.filmapps.domain.model.UserDataParam

interface GetInfoAboutRegisterUseCase {
    suspend fun execute(param: UserDataParam): Result
}