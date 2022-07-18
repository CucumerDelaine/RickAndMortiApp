package com.example.filmapps.domain.UseCase

import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.repositories.UserRepositories

class SaveUserDataUseCase(private val UserRepository: UserRepositories) {

    fun execute(param: SaveUserDataParam): Boolean {
        return UserRepository.saveLoginAndPassword(saveParam = param)
    }
}