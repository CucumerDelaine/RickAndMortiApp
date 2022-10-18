package com.example.feature_auth_impl.domain

import com.example.feature_auth_api.data.AuthRepository
import com.example.feature_auth_api.domain.GetInfoAboutRegisterUseCase
import com.example.feature_auth_api.model.AuthResult
import com.example.feature_auth_api.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetInfoAboutRegisterUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : GetInfoAboutRegisterUseCase {
    override suspend fun execute(param: UserData): AuthResult {
        return if (param.login.isEmpty() || param.pass.isEmpty())
            AuthResult.EmptyError
        else {
            withContext(Dispatchers.IO) {
                try {
                    if (!authRepository.isUserRegistered(userParam = param))
                        AuthResult.ErrorLogin
                    else
                        AuthResult.Success
                } catch (e: Exception) {
                    AuthResult.Error(e)
                }
            }
        }
    }
}