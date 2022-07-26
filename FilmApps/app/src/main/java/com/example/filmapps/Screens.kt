package com.example.filmapps

import com.example.filmapps.presentation.ui.FirstFragment
import com.example.filmapps.presentation.ui.SecondFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Main() = FragmentScreen { FirstFragment() }
    fun AddressSearch() = FragmentScreen { SecondFragment() }
//    fun Profile(userId: Long) = FragmentScreen("Profile_$userId") { ProfileFragment(userId) }
//    fun Browser(url: String) = ActivityScreen { Intent(Intent.ACTION_VIEW, Uri.parse(url))  }
}