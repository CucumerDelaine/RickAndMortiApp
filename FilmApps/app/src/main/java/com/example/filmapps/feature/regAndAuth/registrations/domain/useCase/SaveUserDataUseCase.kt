package com.example.filmapps.feature.regAndAuth.registrations.domain.useCase

import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface SaveUserDataUseCase {
    fun execute(param: UserDataParam): Boolean
}