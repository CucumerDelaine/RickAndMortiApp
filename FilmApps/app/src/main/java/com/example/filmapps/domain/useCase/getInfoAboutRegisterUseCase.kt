package com.example.filmapps.domain.UseCase

import com.example.filmapps.domain.model.UserDataParam

interface GetInfoAboutRegisterUseCase {
    fun execute(param: UserDataParam): Boolean
}