package com.example.filmapps.domain.di.module

import com.example.filmapps.data.retrofit.GetPage
import com.example.filmapps.domain.di.scope.CharacterListScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class CharacterListNetwork {
    
    @Provides
    @CharacterListScope
    fun provideApi(retrofit: Retrofit): GetPage {
        return retrofit.create(GetPage::class.java)
    }
}