package com.example.filmapps

import com.example.filmapps.presentation.ui.AuthorizationFragment
import com.example.filmapps.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Main() = FragmentScreen { RegistrationFragment() }
    fun AddressSearch() = FragmentScreen { AuthorizationFragment() }
//    fun Profile(userId: Long) = FragmentScreen("Profile_$userId") { ProfileFragment(userId) }
//    fun Browser(url: String) = ActivityScreen { Intent(Intent.ACTION_VIEW, Uri.parse(url))  }
}