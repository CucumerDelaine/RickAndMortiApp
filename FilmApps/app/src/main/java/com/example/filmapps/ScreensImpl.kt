package com.example.filmapps

import com.example.core.data.NavigationScreens
import com.example.core.data.model.CoreCharacter
import com.example.feature_auth_impl.presentation.ui.AuthorizationFragment
import com.example.feature_characterlist_impl.presentation.ui.CharacterListFragment
import com.example.feature_details_impl.presentation.ui.DetailsFragment
import com.example.feature_reg_impl.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ScreensImpl : NavigationScreens {

    override fun registrationScreen()= FragmentScreen { RegistrationFragment.getInstance() }
    override fun authorizationScreen() = FragmentScreen { AuthorizationFragment.getInstance() }
    override fun listFilmScreen() = FragmentScreen { CharacterListFragment.getInstance() }
    override fun details(character: CoreCharacter): FragmentScreen = FragmentScreen { DetailsFragment.getNewInstance(character) }
}