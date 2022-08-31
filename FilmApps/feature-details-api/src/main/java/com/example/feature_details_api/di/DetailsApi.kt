package com.example.feature_details_api.di

import com.example.feature_details_api.data.DetailsNavigationRepository

interface DetailsApi {
    fun getNavRepository(): DetailsNavigationRepository
}