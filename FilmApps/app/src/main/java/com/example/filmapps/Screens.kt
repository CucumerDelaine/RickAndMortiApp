package com.example.filmapps

import com.example.filmapps.feature.regAndAuth.authorization.presentation.ui.AuthorizationFragment
import com.example.filmapps.feature.regAndAuth.registrations.presentation.ui.RegistrationFragment
import com.example.filmapps.presentation.ui.CharacterListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun RegistrationScreen() = FragmentScreen { RegistrationFragment() }
    fun AuthorizationScreen() = FragmentScreen { AuthorizationFragment() }
    fun ListFilmScreen() = FragmentScreen { CharacterListFragment() }
//    fun Browser(url: String) = ActivityScreen { Intent(Intent.ACTION_VIEW, Uri.parse(url))  }
}