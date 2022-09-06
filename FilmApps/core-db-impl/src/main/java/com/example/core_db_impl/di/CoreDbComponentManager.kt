package com.example.core_db_impl.di

import com.example.core.di.CoreComponentManager
import com.example.core_db_api.di.CoreDbApi


object CoreDbComponentManager {
    private var coreDbComponent: CoreDbApi? = null

    fun getCoreDbComponent(): CoreDbApi {
        return coreDbComponent ?: DaggerCoreDbComponent
            .builder()
            .coreAppApi(CoreComponentManager.coreComponent)
            .build()
            .also { coreDbComponent = it }
    }
}