package com.example.feature_reg_api.domain

import com.example.feature_reg_api.model.RegResult
import com.example.feature_reg_api.model.UserData

interface SaveUserDataUseCase {
    suspend fun execute(param: UserData): RegResult
}