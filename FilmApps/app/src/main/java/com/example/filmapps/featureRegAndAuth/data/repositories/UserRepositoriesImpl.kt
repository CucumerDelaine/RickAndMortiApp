package com.example.filmapps.featureRegAndAuth.data.repositories


import com.example.filmapps.featureAuthRegApi.data.bd.UserDataDAO
import com.example.filmapps.featureRegAndAuth.data.model.UserData
import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam
import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import javax.inject.Inject

internal class UserRepositoriesImpl @Inject constructor(
    private val userData: UserDataDAO
) : UserRepositories {
    override fun save(userParam: UserDataParam) {
        userData.insert(userData = UserData(login = userParam.login, pass = userParam.pass))
    }

    override fun isUserRegistered(userParam: UserDataParam): Boolean {
        val user: UserData? = userData.getUserData(login = userParam.login, pass = userParam.pass)
        return user != null
    }
}