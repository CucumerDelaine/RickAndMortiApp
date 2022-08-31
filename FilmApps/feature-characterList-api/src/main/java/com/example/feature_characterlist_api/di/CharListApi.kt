package com.example.feature_characterlist_api.di

import com.example.feature_characterlist_api.data.repository.CharacterListNavigationRepository

interface CharListApi {
    fun getNavRepository(): CharacterListNavigationRepository
}