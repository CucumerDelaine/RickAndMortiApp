package com.example.filmapps.data.repositories


import com.example.filmapps.domain.model.SaveUserDataParam
import javax.inject.Inject

internal class UserRepositoriesImpl @Inject constructor() : UserRepositories {
    override fun saveLoginAndPassword(saveParam: SaveUserDataParam): Boolean {
        if(saveParam.login.isEmpty() || saveParam.pass.isEmpty())
            return false
        else
            return true
    }
}