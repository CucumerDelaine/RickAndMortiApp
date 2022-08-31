package com.example.feature_auth_api.data

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface AuthNavigationRepository {
    fun getNewInstance(): FragmentScreen
}