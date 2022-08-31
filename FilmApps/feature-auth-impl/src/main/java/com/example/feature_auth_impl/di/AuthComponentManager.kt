package com.example.feature_auth_impl.di

import com.example.core.viewModel.ViewModelApi
import com.example.feature_auth_api.di.AuthNavigationApi

object AuthComponentManager {

    private var authorizationComponent: ViewModelApi? = null

    fun getAuthorizationComponent(): ViewModelApi? {
        return authorizationComponent
//        return authorizationComponent ?: DaggerAuthComponent
//            .builder()
//            .coreAppApi(CoreComponentManager.coreComponent)
//            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
//            .charListApi(CharacterListComponentManager.getCharListNavigationComponent())
//            .regApi(RegComponentManager.getRegNavigationComponent())
//            .build()
//            .also { authorizationComponent = it }
    }

    fun setAuthComponent(authComponent: ViewModelApi) {
        authorizationComponent = authComponent
    }

    private var authNavComponent: AuthNavigationApi? = null

    fun getAuthNavigationComponent(): AuthNavigationApi {
        return authNavComponent ?: DaggerAuthNavComponent
            .builder()
            .build()
            .also { authNavComponent = it }
    }

    fun clearAuthorizationComponent() {
        authorizationComponent = null
    }
}