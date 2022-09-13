package com.example.core_db_impl.data.repository

import com.example.core_db_api.data.AppInfoRepository
import com.example.core_db_api.model.AppInfo
import com.example.core_db_impl.data.db.AppInfoDAO
import com.example.core_db_impl.data.model.AppInfoEntity
import javax.inject.Inject

class AppInfoRepositoryImpl @Inject constructor(
    private val appInfoDAO: AppInfoDAO
) : AppInfoRepository {
    override fun getInfoById(id: Int): AppInfo {
        val info = appInfoDAO.getById(id) ?: return AppInfo(0, 0, 0)
        return AppInfo(info.id, info.time, info.page)
    }

    override fun saveInfo(info: AppInfo) {
        appInfoDAO.insert(AppInfoEntity(info.id, info.time, info.page))
    }
}