package com.example.feature_characterlist_impl.data.repository

import com.example.feature_characterlist_api.data.repository.CharacterListNavigationRepository
import com.example.feature_characterlist_impl.presentation.ui.CharacterListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class CharacterListNavigationRepositoryImpl @Inject constructor() :
    CharacterListNavigationRepository {
    override fun getNewInstance(): FragmentScreen =
        FragmentScreen { CharacterListFragment.getInstance() }
}