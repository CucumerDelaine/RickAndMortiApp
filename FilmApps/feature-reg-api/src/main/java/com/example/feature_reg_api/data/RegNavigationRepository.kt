package com.example.feature_reg_api.data

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface RegNavigationRepository {
    fun getNewInstance(): FragmentScreen
}