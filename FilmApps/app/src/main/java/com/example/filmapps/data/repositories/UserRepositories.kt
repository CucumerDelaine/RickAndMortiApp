package com.example.filmapps.data.repositories

import com.example.filmapps.domain.model.SaveUserDataParam

interface UserRepositories {

    fun saveLoginAndPassword(saveParam: SaveUserDataParam) : Boolean

    //fun getLoginAndPassword()
}