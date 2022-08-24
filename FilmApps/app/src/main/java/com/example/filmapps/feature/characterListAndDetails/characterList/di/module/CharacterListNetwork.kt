package com.example.filmapps.feature.characterListAndDetails.characterList.di.module

import com.example.filmapps.feature.characterListAndDetails.characterList.data.retrofit.GetPageApi
import com.example.filmapps.feature.characterListAndDetails.characterList.di.scope.CharacterListScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CharacterListNetwork {
    
    @Provides
    @CharacterListScope
    fun provideApi(retrofit: Retrofit): GetPageApi {
        return retrofit.create(GetPageApi::class.java)
    }
}