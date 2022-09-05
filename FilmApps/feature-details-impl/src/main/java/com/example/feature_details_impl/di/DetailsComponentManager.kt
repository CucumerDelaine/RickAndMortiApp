package com.example.feature_details_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core_db_api.di.CoreDbApi
import com.example.feature_details_impl.di.component.DaggerDetailsComponent

object DetailsComponentManager {

    private var detailsComponent: ViewModelApi? = null
    private var coreDbComponent: CoreDbApi? = null
    private var coreComponent: CoreAppApi? = null

    fun getDetailsComponent(): ViewModelApi? {
        return detailsComponent ?: DaggerDetailsComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(coreDbComponent)
            .build()
            .also { detailsComponent = it }
    }

    fun setCoreDbComponent(impl: CoreDbApi) {
        coreDbComponent = impl
    }

    fun setCoreComponent(impl: CoreAppApi) {
        coreComponent = impl
    }

    fun clearDetailsComponent() {
        detailsComponent = null
    }
}