package com.example.feature_reg_api.model

sealed class RegResult {
    object Success : RegResult()
    class Error(val message: Exception) : RegResult()
    object EmptyError : RegResult()
}
