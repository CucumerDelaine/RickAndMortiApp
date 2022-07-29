package com.example.filmapps.data.repositories

import com.example.filmapps.domain.model.UserDataParam

interface UserRepositories {

    fun saveLoginAndPassword(userParam: UserDataParam)

    fun getInfoAboutRegisteredOrNot(userParam: UserDataParam) : Boolean
}