package com.example.filmapps

import android.content.Context
import com.example.core.di.CoreComponentManager
import com.example.core.di.CoreComponentManager.coreComponent
import com.example.core_db_impl.di.CoreDbComponentManager
import com.example.core_network_impl.di.CoreNetworkComponentManager
import com.example.feature_auth_impl.di.AuthComponentManager
import com.example.feature_characterlist_impl.di.CharacterListComponentManager
import com.example.feature_details_impl.di.DetailsComponentManager
import com.example.feature_reg_impl.di.RegComponentManager
import com.example.filmapps.app.di.components.AppComponent
import com.example.filmapps.app.di.components.DaggerAppComponent

object ComponentManager {

    lateinit var appComponent: AppComponent

    fun init(context: Context) {
        CoreComponentManager.getCore(context, ScreensImpl)
        getAppComponent()
        AuthComponentManager.setCoreDbComponent(CoreDbComponentManager.getCoreDbComponent())
        AuthComponentManager.setCoreComponent(coreComponent)
        RegComponentManager.setCoreDbComponent(CoreDbComponentManager.getCoreDbComponent())
        RegComponentManager.setCoreComponent(coreComponent)
        CharacterListComponentManager.setCoreDbComponent(CoreDbComponentManager.getCoreDbComponent())
        CharacterListComponentManager.setCoreComponent(coreComponent)
        CharacterListComponentManager.setCoreNetworkComponent(CoreNetworkComponentManager.getNetworkComponent())
        DetailsComponentManager.setCoreDbComponent(CoreDbComponentManager.getCoreDbComponent())
        DetailsComponentManager.setCoreComponent(coreComponent)

    }

    private fun getAppComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .coreAppApi(coreComponent)
            .build()
    }
}