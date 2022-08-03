package com.example.filmapps.domain.useCase

import com.example.filmapps.Result
import com.example.filmapps.data.repositories.UserRepositories
import com.example.filmapps.domain.model.UserDataParam
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SaveUserDataUseCaseImpl @Inject constructor(
    private val userRepository: UserRepositories
) : SaveUserDataUseCase {
    override suspend fun execute(param: UserDataParam): Result {
        return if (param.login.isEmpty() || param.pass.isEmpty())
            Result.Error("Error")
        else {
            withContext(Dispatchers.IO) {
                try {
                    userRepository.save(userParam = param)
                    return@withContext Result.Success
                } catch (e: Throwable) {
                    return@withContext Result.Error("Error")
                }
            }
        }
    }
}