package com.example.feature_auth_api.model

sealed class AuthResult {
    object Success : AuthResult()
    class Error(val message: Exception) : AuthResult()
    object EmptyError : AuthResult()
    object ErrorLogin : AuthResult()
}