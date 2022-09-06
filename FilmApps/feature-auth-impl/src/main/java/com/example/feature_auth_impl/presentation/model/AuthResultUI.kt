package com.example.feature_auth_impl.presentation.model

sealed interface AuthResultUI {
    object Success : AuthResultUI
    class Error(val message: Exception) : AuthResultUI
    object Loading : AuthResultUI
    object EmptyError : AuthResultUI
}