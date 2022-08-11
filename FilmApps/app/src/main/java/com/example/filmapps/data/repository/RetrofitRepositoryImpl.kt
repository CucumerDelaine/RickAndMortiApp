package com.example.filmapps.data.repository

import com.example.filmapps.data.retrofit.GetPage
import com.example.filmapps.presentation.model.CharacterListResponce
import java.lang.Exception
import javax.inject.Inject

class RetrofitRepositoryImpl @Inject constructor(
    private val retrofit: GetPage
) : RetrofitRepository {
    var page = 0
    private val lastPage = 42

    override suspend fun loadList(): CharacterListResponce {
        page++
        if (page == lastPage + 1)
            return CharacterListResponce.Finally
        return try {
            CharacterListResponce.Success(retrofit.getPage(page))
        } catch (e: Exception) {
            CharacterListResponce.Error(e)
        }
    }
}