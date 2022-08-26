package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.module

import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.retrofit.GetPageApi
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.scope.CharacterListScope
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