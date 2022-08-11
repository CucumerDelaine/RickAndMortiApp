package com.example.filmapps.data.repository

import com.example.filmapps.presentation.model.CharacterListResponce

interface RetrofitRepository {
    suspend fun loadList(): CharacterListResponce
}