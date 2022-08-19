package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult

interface CharacterListRepository {
    suspend fun loadCharacterList(page: Int): LoadCharacterListResponse
    suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult
    suspend fun getCharacterList(): GetCharacterListResponse
    suspend fun clearDatabase(characterList: List<Character>?)
}