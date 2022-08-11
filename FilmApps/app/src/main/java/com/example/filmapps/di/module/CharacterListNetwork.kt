package com.example.filmapps.di.module

import com.example.filmapps.data.retrofit.GetPage
import com.example.filmapps.di.scope.CharacterListScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CharacterListNetwork {
    
    @Provides
    @CharacterListScope
    fun provideApi(retrofit: Retrofit): GetPage {
        return retrofit.create(GetPage::class.java)
    }
}