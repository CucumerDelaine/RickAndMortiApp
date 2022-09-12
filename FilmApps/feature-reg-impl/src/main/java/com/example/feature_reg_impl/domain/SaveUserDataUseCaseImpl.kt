package com.example.feature_reg_impl.domain

import com.example.feature_reg_api.data.RegRepository
import com.example.feature_reg_api.domain.SaveUserDataUseCase
import com.example.feature_reg_api.model.RegResult
import com.example.feature_reg_api.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveUserDataUseCaseImpl @Inject constructor(
    private val regRepository: RegRepository
) : SaveUserDataUseCase {
    override suspend fun execute(param: UserData): RegResult {
        return if (param.login.isEmpty() || param.pass.isEmpty())
            RegResult.EmptyError
        else {
            withContext(Dispatchers.IO) {
                try {
                    regRepository.save(userParam = param)
                    RegResult.Success
                } catch (e: Exception) {
                    RegResult.Error(e)
                }
            }
        }
    }
}