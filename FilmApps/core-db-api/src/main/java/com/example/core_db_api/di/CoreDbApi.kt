package com.example.core_db_api.di

import com.example.core_db_api.data.AppInfoRepository
import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.data.UserDataRepository

interface CoreDbApi {
    fun getUserDataDb(): UserDataRepository
    fun getCharacterListDb(): CharacterListRepository
    fun getAppInfoDb(): AppInfoRepository
}