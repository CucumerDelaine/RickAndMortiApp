package com.example.feature_characterlist_impl.di

import com.example.core.viewModel.ViewModelApi
import com.example.feature_characterlist_api.di.CharListApi

object CharacterListComponentManager {

    private var characterListComponent: ViewModelApi? = null

    fun getCharacterListComponent(): ViewModelApi? {
        return characterListComponent
//        return characterListComponent ?: DaggerCharacterListComponent
//            .builder()
//            .coreAppApi(CoreComponentManager.coreComponent)
//            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
//            .coreNetworkApi(CoreNetworkComponentManager.getNetworkComponent())
//            .detailsApi(DetailsComponentManager.getDetailsNavigationComponent())
//            .build()
//            .also { characterListComponent = it }
    }

    fun setCharacterListComponent(charComponent: ViewModelApi) {
        characterListComponent = charComponent
    }

    private var charListNavComponent: CharListApi? = null

    fun getCharListNavigationComponent(): CharListApi {
        return charListNavComponent ?: DaggerCharacterListNavigationComponent
            .builder()
            .build()
            .also { charListNavComponent = it }
    }

    fun clearCharacterListComponent() {
        characterListComponent = null
    }
}