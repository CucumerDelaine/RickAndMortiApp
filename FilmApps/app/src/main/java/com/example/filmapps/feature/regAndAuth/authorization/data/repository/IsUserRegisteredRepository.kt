package com.example.filmapps.feature.regAndAuth.authorization.data.repository

import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface IsUserRegisteredRepository {
    fun isUserRegistered(userParam: UserDataParam) : Boolean
}