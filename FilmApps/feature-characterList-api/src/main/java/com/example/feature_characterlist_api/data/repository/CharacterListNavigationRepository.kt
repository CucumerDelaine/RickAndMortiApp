package com.example.feature_characterlist_api.data.repository

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface CharacterListNavigationRepository {
    fun getNewInstance(): FragmentScreen
}