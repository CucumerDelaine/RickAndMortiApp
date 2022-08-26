package com.example.filmapps.featureRegAndAuth.featureAuthorization.domain.useCase

import com.example.filmapps.featureRegAndAuth.presentation.model.Result
import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam

interface GetInfoAboutRegisterUseCase {
    suspend fun execute(param: UserDataParam): Result
}