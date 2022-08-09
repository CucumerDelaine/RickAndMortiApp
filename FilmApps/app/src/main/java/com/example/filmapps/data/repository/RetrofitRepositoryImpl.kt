package com.example.filmapps.data.repository

import com.example.filmapps.data.retrofit.GetPage
import com.example.filmapps.presentation.model.Request
import java.lang.Exception
import javax.inject.Inject

class RetrofitRepositoryImpl @Inject constructor(
    private val retrofit: GetPage
): RetrofitRepository {

    override suspend fun loadList(): Request {
        return try {
            Request.Success(retrofit.getPage())
        }
        catch (e: Exception) {
            Request.Error(e)
        }
    }
}