package com.example.filmapps.data.repository

import com.example.filmapps.presentation.model.CharacterDetailsResponce

interface GetCharacterRepository {
    suspend fun loadCharacter(id: String): CharacterDetailsResponce
}