package com.example.core.viewModel

import androidx.lifecycle.ViewModelProvider

interface ViewModelApi {
    fun viewModelFactory(): ViewModelProvider.Factory
}