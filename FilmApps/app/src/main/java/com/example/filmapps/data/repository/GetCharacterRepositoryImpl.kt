package com.example.filmapps.data.repository

import com.example.filmapps.data.retrofit.GetCharacterApi
import com.example.filmapps.presentation.model.CharacterDetailsResponce
import java.lang.Exception
import javax.inject.Inject

class GetCharacterRepositoryImpl @Inject constructor(
    private val retrofit: GetCharacterApi
): GetCharacterRepository {
    override suspend fun loadCharacter(id: String): CharacterDetailsResponce {
        return try {
            CharacterDetailsResponce.Success(retrofit.getCharacter(id))
        } catch (e: Exception) {
            CharacterDetailsResponce.Error(e)
        }
    }
}