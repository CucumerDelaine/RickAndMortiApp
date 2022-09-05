package com.example.feature_characterlist_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core_db_api.di.CoreDbApi
import com.example.core_network_api.di.CoreNetworkApi

object CharacterListComponentManager {

    private var characterListComponent: ViewModelApi? = null
    private var coreDbComponent: CoreDbApi? = null
    private var coreComponent: CoreAppApi? = null
    private var coreNetworkComponent: CoreNetworkApi? = null

    fun getCharacterListComponent(): ViewModelApi? {
        return characterListComponent ?: DaggerCharacterListComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(coreDbComponent)
            .coreNetworkApi(coreNetworkComponent)
            .build()
            .also { characterListComponent = it }
    }

    fun setCoreDbComponent(impl: CoreDbApi) {
        coreDbComponent = impl
    }

    fun setCoreComponent(impl: CoreAppApi) {
        coreComponent = impl
    }
    fun setCoreNetworkComponent(impl: CoreNetworkApi) {
        coreNetworkComponent = impl
    }

    fun clearCharacterListComponent() {
        characterListComponent = null
    }
}