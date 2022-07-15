package com.example.filmapps.Data.Repositories

import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.repositories.UserRepositories

class UserRepositoriesImpl : UserRepositories {
    override fun saveLoginAndPassword(saveParam: SaveUserDataParam): Boolean {

        if(saveParam.login.isEmpty() || saveParam.pass.isEmpty())
            return false
        else
            return true
    }
}