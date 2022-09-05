package com.example.feature_reg_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core_db_api.di.CoreDbApi

object RegComponentManager {

    private var registrationComponent: ViewModelApi? = null
    private var coreDbComponent: CoreDbApi? = null
    private var coreComponent: CoreAppApi? = null

    fun getRegistrationComponent(): ViewModelApi? {
        return registrationComponent  ?: DaggerRegComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(coreDbComponent)
            .build()
            .also { registrationComponent = it }
    }

    fun setCoreDbComponent(impl: CoreDbApi) {
        coreDbComponent = impl
    }

    fun setCoreComponent(impl: CoreAppApi) {
        coreComponent = impl
    }

    fun clearRegistrationComponent() {
        registrationComponent = null
    }

}