package com.example.filmapps.domain.di.module

import com.example.filmapps.data.retrofit.GetPage
import com.example.filmapps.domain.di.scope.CharacterListScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    @CharacterListScope
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
    }

    @Provides
    @CharacterListScope
    fun provideApi(retrofit: Retrofit): GetPage {
        return retrofit.create(GetPage::class.java)
    }
}