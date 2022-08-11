package com.example.filmapps.data.repository

import com.example.filmapps.data.retrofit.GetPage
import com.example.filmapps.presentation.model.CharacterListResponce
import java.lang.Exception
import javax.inject.Inject

class RetrofitRepositoryImpl @Inject constructor(
    private val retrofit: GetPage
): RetrofitRepository {

    override suspend fun loadList(): CharacterListResponce {
        return try {
            CharacterListResponce.Success(retrofit.getPage())
        }
        catch (e: Exception) {
            CharacterListResponce.Error(e)
        }
    }
}