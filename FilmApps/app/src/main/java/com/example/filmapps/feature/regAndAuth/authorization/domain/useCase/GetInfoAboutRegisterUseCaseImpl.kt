package com.example.filmapps.feature.regAndAuth.authorization.domain.useCase

import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositories
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import javax.inject.Inject

class GetInfoAboutRegisterUseCaseImpl @Inject constructor(
    private val userRepository: UserRepositories
) : GetInfoAboutRegisterUseCase {
    override fun execute(param: UserDataParam): Boolean {
        return if(param.login.isEmpty() || param.pass.isEmpty())
            false
        else
            userRepository.getInfoAboutRegisteredOrNot(userParam = param)
    }
}


