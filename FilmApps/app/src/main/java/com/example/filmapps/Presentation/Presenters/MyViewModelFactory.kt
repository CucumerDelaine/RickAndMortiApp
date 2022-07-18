package com.example.filmapps.Presentation.Presenters

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmapps.Data.Repositories.UserRepositoriesImpl
import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase

class MyViewModelFactory : ViewModelProvider.Factory {

    private val userRepositories = UserRepositoriesImpl()
    private val saveUserDataUseCase = SaveUserDataUseCase(UserRepository = userRepositories)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(saveUserDataUseCase = saveUserDataUseCase) as T
    }
}