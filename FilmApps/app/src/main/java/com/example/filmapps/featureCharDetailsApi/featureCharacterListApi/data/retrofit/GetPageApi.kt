package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.retrofit

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.model.DataApi
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPageApi {

    @GET("character/")
    suspend fun getPage(@Query("page") page: Int): DataApi
}