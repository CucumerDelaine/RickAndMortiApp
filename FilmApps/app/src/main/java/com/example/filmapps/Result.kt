package com.example.filmapps

sealed class Result {
    object Success : Result()
    class   Error(val message: String) : Result()
}