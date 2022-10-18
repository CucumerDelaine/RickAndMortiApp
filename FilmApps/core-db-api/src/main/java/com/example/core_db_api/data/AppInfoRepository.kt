package com.example.core_db_api.data

import com.example.core_db_api.model.AppInfo

interface AppInfoRepository {
    fun getInfoById(id: Int): AppInfo
    fun saveInfo(info: AppInfo)
}