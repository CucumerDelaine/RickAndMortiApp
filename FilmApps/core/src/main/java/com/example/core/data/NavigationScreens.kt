package com.example.core.data

import com.example.core.data.model.CoreCharacter
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface NavigationScreens {

    fun registrationScreen(): FragmentScreen
    fun authorizationScreen(): FragmentScreen
    fun listFilmScreen(): FragmentScreen
    fun details(character: CoreCharacter): FragmentScreen
}