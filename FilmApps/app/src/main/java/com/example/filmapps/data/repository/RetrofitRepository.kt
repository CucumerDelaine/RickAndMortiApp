package com.example.filmapps.data.repository

import com.example.filmapps.presentation.model.Request

interface RetrofitRepository {
    suspend fun loadList(): Request
}