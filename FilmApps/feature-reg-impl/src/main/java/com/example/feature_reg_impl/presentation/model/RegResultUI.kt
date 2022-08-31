package com.example.feature_reg_impl.presentation.model

sealed interface RegResultUI {
    object Success : RegResultUI
    class Error(val message: Exception) : RegResultUI
    object Loading : RegResultUI
    object EmptyError : RegResultUI
}
