package com.example.filmapps.feature.regAndAuth.authorization.data.repository

import com.example.filmapps.data.bd.UserDataDAO
import com.example.filmapps.feature.regAndAuth.data.model.UserData
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import javax.inject.Inject

internal class IsUserRegisteredRepositoryImpl @Inject constructor(
    private val userData: UserDataDAO
) :  IsUserRegisteredRepository {
    override fun isUserRegistered(userParam: UserDataParam): Boolean {
        val user: UserData? = userData.getUserData(login = userParam.login, pass = userParam.pass)
        return user != null
    }
}