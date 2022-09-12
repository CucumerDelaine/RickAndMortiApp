package com.example.feature_reg_impl.data

import com.example.core_db_api.data.UserDataRepository
import com.example.core_db_api.model.User
import com.example.feature_reg_api.data.RegRepository
import com.example.feature_reg_api.model.RegResult
import com.example.feature_reg_api.model.UserData
import javax.inject.Inject

class RegRepositoryImpl @Inject constructor(
    private val userDataRepository: UserDataRepository
) : RegRepository {
    override fun save(userParam: UserData) {
        userDataRepository.save(User(userParam.login, userParam.pass))
    }
}