package com.example.filmapps.appApi.di

import android.content.Context
import com.example.filmapps.featureAuthRegApi.data.bd.UserDataDAO
import com.example.filmapps.featureCharDetailsApi.data.bd.CharacterListDAO
import com.github.terrakok.cicerone.Router
import retrofit2.Retrofit

interface AppApi {

    fun getRouter(): Router
    fun getContext(): Context
    fun getDatabase(): UserDataDAO
    fun getRetrofit(): Retrofit
    fun getCharacterDatabase(): CharacterListDAO
}