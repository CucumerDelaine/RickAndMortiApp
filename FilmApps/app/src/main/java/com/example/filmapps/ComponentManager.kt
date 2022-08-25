package com.example.filmapps

import android.content.Context
import com.example.filmapps.di.components.*
import com.example.filmapps.di.module.ContextModule
import com.example.filmapps.feature.characterListAndDetails.characterList.di.components.CharacterListComponent
import com.example.filmapps.feature.characterListAndDetails.characterList.di.components.DaggerCharacterListComponent
import com.example.filmapps.feature.characterListAndDetails.details.di.components.DetailsComponent

object ComponentManager {

    lateinit var appComponent: AppComponent

    private var authorizationComponent: AuthorizationComponent? = null
    private var registrationComponent: RegistrationComponent? = null
    private var characterListComponent: CharacterListComponent? = null
    private var detailsComponent: DetailsComponent? = null


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

    fun getCharacterListComponent(): CharacterListComponent {
        return characterListComponent  ?: DaggerCharacterListComponent
            .builder()
            .appComponent(appComponent)
            .build()
            .also { characterListComponent = it }
    }

    fun clearCharacterListComponent() {
        characterListComponent = null
    }

    fun getDetailsComponent(): DetailsComponent {
        return detailsComponent  ?: DaggerDetailsComponent
            .builder()
            .appComponent(appComponent)
            .build()
            .also { detailsComponent = it }
    }

    fun clearDetailsComponent() {
        detailsComponent = null
    }
}