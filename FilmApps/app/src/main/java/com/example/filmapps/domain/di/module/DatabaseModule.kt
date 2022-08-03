package com.example.filmapps.domain.di.module

import android.content.Context
import androidx.room.Room
import com.example.filmapps.data.UserDataBase
import com.example.filmapps.data.UserDataDAO
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

}