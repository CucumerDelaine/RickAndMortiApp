package com.example.filmapps.feature.regAndAuth.registrations.data.repository

import com.example.filmapps.data.bd.UserDataDAO
import com.example.filmapps.feature.regAndAuth.data.model.UserData
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import javax.inject.Inject

internal class SaveUserDataRepositoryImpl @Inject constructor(
    private val userData: UserDataDAO
) : SaveUserDataRepository {
    override fun save(userParam: UserDataParam) {
        userData.insert(userData = UserData(login = userParam.login, pass = userParam.pass))
    }
}