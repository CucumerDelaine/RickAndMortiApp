package com.example.filmapps

import com.example.filmapps.Presentation.UI.ListFilmFragment
import com.example.filmapps.presentation.ui.AuthorizationFragment
import com.example.filmapps.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun RegistrationScreen() = FragmentScreen { RegistrationFragment() }
    fun AuthorizationScreen() = FragmentScreen { AuthorizationFragment() }
    fun ListFilmScreen() = FragmentScreen { ListFilmFragment() }
//    fun Browser(url: String) = ActivityScreen { Intent(Intent.ACTION_VIEW, Uri.parse(url))  }
}