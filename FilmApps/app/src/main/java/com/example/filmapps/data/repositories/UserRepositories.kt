package com.example.filmapps.data.repositories

import com.example.filmapps.domain.model.UserDataParam

interface UserRepositories {

    fun save(userParam: UserDataParam)

    fun isUserRegistered(userParam: UserDataParam) : Boolean
}