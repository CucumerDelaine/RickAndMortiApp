package com.example.filmapps

import android.content.Context
import com.example.core.di.CoreComponentManager
import com.example.core.di.CoreComponentManager.coreComponent
import com.example.core.viewModel.ViewModelApi
import com.example.core_db_impl.di.CoreDbComponentManager
import com.example.core_network_impl.di.CoreNetworkComponentManager
import com.example.feature_auth_impl.di.AuthComponentManager
import com.example.feature_auth_impl.di.DaggerAuthComponent
import com.example.feature_characterlist_impl.di.CharacterListComponentManager
import com.example.feature_characterlist_impl.di.DaggerCharacterListComponent
import com.example.feature_details_impl.di.DetailsComponentManager
import com.example.feature_details_impl.di.component.DaggerDetailsComponent
import com.example.feature_reg_impl.di.DaggerRegComponent
import com.example.feature_reg_impl.di.RegComponentManager
import com.example.filmapps.app.di.components.AppComponent
import com.example.filmapps.app.di.components.DaggerAppComponent

object ComponentManager {

    lateinit var appComponent: AppComponent
    lateinit var characterListComponent: ViewModelApi
    lateinit var authorizationComponent: ViewModelApi
    lateinit var detailsComponent: ViewModelApi
    lateinit var registrationComponent: ViewModelApi

    fun init(context: Context) {
        CoreComponentManager.getCore(context)
        getAppManager()
        authorizationComponent = DaggerAuthComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .charListApi(CharacterListComponentManager.getCharListNavigationComponent())
            .regApi(RegComponentManager.getRegNavigationComponent())
            .build()
        registrationComponent = DaggerRegComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .authNavigationApi(AuthComponentManager.getAuthNavigationComponent())
            .build()
        characterListComponent = DaggerCharacterListComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .coreNetworkApi(CoreNetworkComponentManager.getNetworkComponent())
            .detailsApi(DetailsComponentManager.getDetailsNavigationComponent())
            .build()
        detailsComponent = DaggerDetailsComponent
            .builder()
            .coreAppApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .charListApi(CharacterListComponentManager.getCharListNavigationComponent())
            .build()
        AuthComponentManager.setAuthComponent(authorizationComponent)
        RegComponentManager.setRegComponent(registrationComponent)
        CharacterListComponentManager.setCharacterListComponent(characterListComponent)
        DetailsComponentManager.setDetailsComponent(detailsComponent)

    }

    private fun getAppManager() {
        appComponent = DaggerAppComponent
            .builder()
            .coreAppApi(coreComponent)
            .build()
    }
}