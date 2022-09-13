package com.example.feature_auth_impl.data

import com.example.core_db_api.data.UserDataRepository
import com.example.core_db_api.model.User
import com.example.feature_auth_api.data.AuthRepository
import com.example.feature_auth_api.model.AuthResult
import com.example.feature_auth_api.model.UserData

import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val userDataRepository: UserDataRepository
) : AuthRepository {
    override fun isUserRegistered(userParam: UserData): Boolean {
        val it = userDataRepository.getUserData(login = userParam.login, pass = userParam.pass)
        if(it == null)
            return false
        return true
    }
}