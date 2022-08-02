package com.example.filmapps.feature.regAndAuth

sealed class Result {
    object Success : Result()
    class   Error(val message: String) : Result()
}