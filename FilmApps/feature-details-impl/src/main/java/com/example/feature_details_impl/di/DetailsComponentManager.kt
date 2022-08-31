package com.example.feature_details_impl.di

import com.example.core.viewModel.ViewModelApi
import com.example.feature_details_api.di.DetailsApi
import com.example.feature_details_impl.di.component.DaggerDetailsNavComponent

object DetailsComponentManager {

    private var detailsComponent: ViewModelApi? = null

    fun getDetailsComponent(): ViewModelApi? {
        return detailsComponent
//        return detailsComponent  ?: DaggerDetailsComponent
//            .builder()
//            .coreAppApi(CoreComponentManager.coreComponent)
//            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
//            .build()
//            .also { detailsComponent = it }
    }

    fun setDetailsComponent(detailComponent: ViewModelApi) {
        detailsComponent = detailComponent
    }

    private var detailsNavComponent: DetailsApi? = null

    fun getDetailsNavigationComponent(): DetailsApi {
        return detailsNavComponent ?: DaggerDetailsNavComponent
            .builder()
            .build()
            .also { detailsNavComponent = it }
    }

    fun clearDetailsComponent() {
        detailsComponent = null
    }
}