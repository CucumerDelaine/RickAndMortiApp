package com.example.feature_reg_impl.di

import com.example.core.viewModel.ViewModelApi
import com.example.feature_reg_api.di.RegApi

object RegComponentManager {

    private var registrationComponent: ViewModelApi? = null

    fun getRegistrationComponent(): ViewModelApi? {
        return registrationComponent
//        return registrationComponent  ?: DaggerRegComponent
//            .builder()
//            .coreAppApi(CoreComponentManager.coreComponent)
//            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
//            .build()
//            .also { registrationComponent = it }
    }

    fun setRegComponent(regComponent: ViewModelApi) {
        registrationComponent = regComponent
    }

    private var regNavComponent: RegApi? = null

    fun getRegNavigationComponent(): RegApi {
        return regNavComponent ?: DaggerRegNavComponent
            .builder()
            .build()
            .also { regNavComponent = it }
    }

    fun clearRegistrationComponent() {
        registrationComponent = null
    }

}