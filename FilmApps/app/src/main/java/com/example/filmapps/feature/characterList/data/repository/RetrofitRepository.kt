package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterList.presentation.model.CharacterListResponce

interface RetrofitRepository {
    suspend fun loadList(): CharacterListResponce
}