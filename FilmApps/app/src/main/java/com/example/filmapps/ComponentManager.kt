package com.example.filmapps

import android.content.Context
import com.example.filmapps.domain.di.components.*
import com.example.filmapps.domain.di.module.ContextModule

object ComponentManager {

    lateinit var appComponent: AppComponent

    private var authorizationComponent: AuthorizationComponent? = null
    private var registrationComponent: RegistrationComponent? = null


    fun init(context: Context) {
        appComponent = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(context = context))
            .build()
    }

    fun getAuthorizationComponent(): AuthorizationComponent {
        return authorizationComponent  ?: DaggerAuthorizationComponent
            .builder()
            .appComponent(appComponent)
            .build()
            .also { authorizationComponent = it }
    }

    fun clearAuthorizationComponent() {
        authorizationComponent = null
    }


    fun getRegistrationComponent(): RegistrationComponent{
        return registrationComponent  ?: DaggerRegistrationComponent
            .builder()
            .appComponent(appComponent)
            .build()
            .also { registrationComponent = it }
    }

    fun clearRegistrationComponent() {
        registrationComponent = null
    }
}