package com.example.filmapps.data.retrofit

import com.example.filmapps.data.model.DataApi
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPage {

    @GET("character/")
    suspend fun getPage(@Query("page") page: Int): DataApi
}