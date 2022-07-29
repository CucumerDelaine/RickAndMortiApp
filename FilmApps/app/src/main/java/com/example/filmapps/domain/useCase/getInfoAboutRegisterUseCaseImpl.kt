package com.example.filmapps.domain.UseCase

import com.example.filmapps.data.repositories.UserRepositories
import com.example.filmapps.domain.model.UserDataParam
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


