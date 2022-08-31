package com.example.filmapps

import com.example.core_db_api.model.Character
import com.example.feature_auth_impl.presentation.ui.AuthorizationFragment
import com.example.feature_characterlist_impl.presentation.ui.CharacterListFragment
import com.example.feature_details_impl.presentation.ui.DetailsFragment
import com.example.feature_reg_impl.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun registrationScreen() = FragmentScreen { RegistrationFragment() }
    fun authorizationScreen() = FragmentScreen { AuthorizationFragment() }
    fun listFilmScreen() = FragmentScreen { CharacterListFragment() }
    fun details(character: Character) = FragmentScreen { DetailsFragment.getNewInstance(character) }
}