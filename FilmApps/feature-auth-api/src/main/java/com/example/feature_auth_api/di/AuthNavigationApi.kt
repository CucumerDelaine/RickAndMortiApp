package com.example.feature_auth_api.di

import com.example.feature_auth_api.data.AuthNavigationRepository

interface AuthNavigationApi {
    fun getNavRepository(): AuthNavigationRepository
}