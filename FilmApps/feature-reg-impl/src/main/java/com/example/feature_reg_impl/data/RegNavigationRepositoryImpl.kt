package com.example.feature_reg_impl.data

import com.example.feature_reg_api.data.RegNavigationRepository
import com.example.feature_reg_impl.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class RegNavigationRepositoryImpl @Inject constructor() : RegNavigationRepository {
    override fun getNewInstance(): FragmentScreen =
        FragmentScreen { RegistrationFragment.getInstance() }
}