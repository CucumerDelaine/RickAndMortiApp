package com.example.feature_auth_impl.data

import com.example.feature_auth_api.data.AuthNavigationRepository

import com.example.feature_auth_impl.presentation.ui.AuthorizationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class AuthNavigationRepositoryImpl @Inject constructor() : AuthNavigationRepository {
    override fun getNewInstance(): FragmentScreen =
        FragmentScreen { AuthorizationFragment.getInstance() }
}