package com.example.filmapps.data.retrofit

import com.example.filmapps.data.model.DataApi
import retrofit2.http.GET

interface GetPage {

    @GET("character")
    suspend fun getPage(): DataApi
}