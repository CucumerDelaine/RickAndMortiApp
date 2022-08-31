package com.example.feature_details_impl.data

import com.example.core_db_api.model.Character
import com.example.feature_details_api.data.DetailsNavigationRepository
import com.example.feature_details_impl.presentation.ui.DetailsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class DetailsNavigationRepositoryImpl @Inject constructor() : DetailsNavigationRepository {
    override fun getNewInstance(character: Character): FragmentScreen =
        FragmentScreen { DetailsFragment.getNewInstance(character) }
}