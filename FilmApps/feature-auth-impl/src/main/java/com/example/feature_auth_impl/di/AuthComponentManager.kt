package com.example.feature_auth_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core_db_api.di.CoreDbApi

object AuthComponentManager {

    private var authorizationComponent: ViewModelApi? = null
    private var coreDbComponent: CoreDbApi? = null
    private var coreComponent: CoreAppApi? = null

    fun getAuthorizationComponent(): ViewModelApi {
        return authorizationComponent ?: DaggerAuthComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(coreDbComponent)
            .build()
            .also { authorizationComponent = it }
    }

    fun setCoreDbComponent(impl: CoreDbApi) {
        coreDbComponent = impl
    }

    fun setCoreComponent(impl: CoreAppApi) {
        coreComponent = impl
    }

    fun clearAuthorizationComponent() {
        authorizationComponent = null
    }
}