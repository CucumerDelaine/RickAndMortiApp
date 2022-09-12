package com.example.feature_reg_api.data

import com.example.feature_reg_api.model.RegResult
import com.example.feature_reg_api.model.UserData

interface RegRepository {
    fun save(userParam: UserData)
}