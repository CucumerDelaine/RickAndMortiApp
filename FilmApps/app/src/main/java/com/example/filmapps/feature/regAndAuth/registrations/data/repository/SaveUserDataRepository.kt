package com.example.filmapps.feature.regAndAuth.registrations.data.repository

import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface SaveUserDataRepository {
    fun save(userParam: UserDataParam)
}