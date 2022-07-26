package com.example.filmapps.domain.useCase

import com.example.filmapps.domain.model.SaveUserDataParam
import com.example.filmapps.data.repositories.UserRepositories
import javax.inject.Inject

internal class SaveUserDataUseCaseImpl @Inject constructor(
    private val userRepository: UserRepositories
    ): SaveUserDataUseCase {

    override fun execute(param: SaveUserDataParam): Boolean {
        return userRepository.saveLoginAndPassword(saveParam = param)
    }
}