package com.example.filmapps.domain.di.module

import com.example.filmapps.Data.Repositories.UserRepositoriesImpl
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase
import com.example.filmapps.domain.repositories.UserRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class AuthorizationModule {

    @Provides
    fun provideUserRepositories() : UserRepositories {
        return UserRepositoriesImpl()
    }

    @Provides
    fun provideSaveUserDataUseCase(userRepositories: UserRepositories) : SaveUserDataUseCase {
        return SaveUserDataUseCase(userRepository = userRepositories)
    }
}