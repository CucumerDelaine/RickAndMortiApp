package com.example.filmapps.Presentation.Presenters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase

class ViewModelFactory(private val saveUserDataUseCase: SaveUserDataUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SaveUserDataViewModel(saveUserDataUseCase = saveUserDataUseCase) as T
    }
}