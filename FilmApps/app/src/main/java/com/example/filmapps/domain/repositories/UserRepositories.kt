package com.example.filmapps.domain.repositories

import com.example.filmapps.domain.Entities.SaveUserDataParam

interface UserRepositories {

    fun saveLoginAndPassword(saveParam: SaveUserDataParam) : Boolean

    //fun getLoginAndPassword()
}