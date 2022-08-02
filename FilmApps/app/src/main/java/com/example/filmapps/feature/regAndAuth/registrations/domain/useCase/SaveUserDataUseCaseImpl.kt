package com.example.filmapps.feature.regAndAuth.registrations.domain.useCase

import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositories
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import javax.inject.Inject

internal class SaveUserDataUseCaseImpl @Inject constructor(
    private val userRepository: UserRepositories
) : SaveUserDataUseCase {
    override fun execute(param: UserDataParam): Boolean {
        if (param.login.isEmpty() || param.pass.isEmpty())
            return false
        else {
            userRepository.saveLoginAndPassword(userParam = param)
            return true
        }
    }
}