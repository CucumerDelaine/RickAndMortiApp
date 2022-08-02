package com.example.filmapps

import com.example.filmapps.feature.regAndAuth.authorization.presentation.ui.AuthorizationFragment
import com.example.filmapps.feature.regAndAuth.registrations.presentation.ui.RegistrationFragment
import com.example.filmapps.presentation.ui.ListFilmFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun RegistrationScreen() = FragmentScreen { RegistrationFragment() }
    fun AuthorizationScreen() = FragmentScreen { AuthorizationFragment() }
    fun ListFilmScreen() = FragmentScreen { ListFilmFragment() }
//    fun Details() = ActivityScreen { }
}