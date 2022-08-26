package com.example.filmapps.app.di.module

import android.content.Context
import androidx.room.Room
import com.example.filmapps.featureCharDetailsApi.data.bd.CharacterListDAO
import com.example.filmapps.app.data.bd.UserDataBase
import com.example.filmapps.featureAuthRegApi.data.bd.UserDataDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMyDatabase(context: Context): UserDataBase {
        return Room.databaseBuilder(context, UserDataBase::class.java, "my-db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDataBase: UserDataBase): UserDataDAO {
        return userDataBase.userDataDao()
    }

    @Singleton
    @Provides
    fun provideCharacterListDao(userDataBase: UserDataBase): CharacterListDAO {
        return userDataBase.characterListDao()
    }

}