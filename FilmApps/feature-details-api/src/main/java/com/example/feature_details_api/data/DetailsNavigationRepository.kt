package com.example.feature_details_api.data

import com.example.core_db_api.model.Character
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface DetailsNavigationRepository {
    fun getNewInstance(character: Character): FragmentScreen
}