package com.example.filmapps.domain.di.module

import com.example.filmapps.Data.Repositories.UserRepositoriesImpl
import com.example.filmapps.Presentation.Presenters.ViewModelFactory
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase
import com.example.filmapps.domain.repositories.UserRepositories
import dagger.Module
import dagger.Provides


@Module
class AuthorizationModule {

    @Provides
    fun provideUserRepositories() : UserRepositories {
        return UserRepositoriesImpl()
    }

    @Provides
    fun provideSaveUserDataUseCase(userRepositories: UserRepositories) : SaveUserDataUseCase {
        return SaveUserDataUseCase(UserRepository = userRepositories)
    }

    @Provides
    fun provideViewModelFactory(saveUserDataUseCase: SaveUserDataUseCase) : ViewModelFactory {
        return ViewModelFactory(saveUserDataUseCase = saveUserDataUseCase)
    }
}