package com.example.filmapps.domain.UseCase

import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.repositories.UserRepositories


class SaveUserDataUseCase(private val userRepository: UserRepositories) {

    fun execute(param: SaveUserDataParam): Boolean {
        return userRepository.saveLoginAndPassword(saveParam = param)
    }
}