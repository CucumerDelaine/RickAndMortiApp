package com.example.core_network_api.di

import com.example.core_network_api.data.CoreNetworkRepository

interface CoreNetworkApi {
    fun getNetworkRepository(): CoreNetworkRepository
}