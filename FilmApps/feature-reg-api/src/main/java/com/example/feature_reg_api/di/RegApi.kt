package com.example.feature_reg_api.di

import com.example.feature_reg_api.data.RegNavigationRepository

interface RegApi {
    fun getNavRepository(): RegNavigationRepository
}