package com.example.core_network_impl.di

import com.example.core_network_api.data.CoreNetworkRepository
import com.example.core_network_impl.data.CoreNetworkRepositoryImpl
import com.example.core_network_impl.data.GetPageApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): GetPageApi {
        return retrofit.create(GetPageApi::class.java)
    }
}

@Module
internal interface NetworkModuleBinds {

    @Binds
    @Singleton
    fun bindsNetworkRepository(impl: CoreNetworkRepositoryImpl): CoreNetworkRepository

}