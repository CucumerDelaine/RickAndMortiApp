package com.example.feature_auth_api.domain

import com.example.feature_auth_api.model.AuthResult
import com.example.feature_auth_api.model.UserData

interface GetInfoAboutRegisterUseCase {
    suspend fun execute(param: UserData): AuthResult
}