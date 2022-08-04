package com.example.filmapps.feature.regAndAuth.authorization.domain.useCase

import com.example.filmapps.feature.regAndAuth.Result
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface GetInfoAboutRegisterUseCase {
    suspend fun execute(param: UserDataParam): Result
}