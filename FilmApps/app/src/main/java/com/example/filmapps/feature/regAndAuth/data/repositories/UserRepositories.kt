package com.example.filmapps.feature.regAndAuth.data.repositories

import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface UserRepositories {

    fun saveLoginAndPassword(userParam: UserDataParam)

    fun getInfoAboutRegisteredOrNot(userParam: UserDataParam) : Boolean
}