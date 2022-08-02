package com.example.filmapps.feature.regAndAuth.authorization.domain.useCase

import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface GetInfoAboutRegisterUseCase {
    fun execute(param: UserDataParam): Boolean
}