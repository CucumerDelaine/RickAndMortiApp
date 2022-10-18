package com.example.feature_auth_api.data

import com.example.feature_auth_api.model.UserData

interface AuthRepository {
    fun isUserRegistered(userParam: UserData): Boolean
}