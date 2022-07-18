package com.example.filmapps.Presentation.Presenters

import androidx.lifecycle.ViewModel
import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase

class MyViewModel(private val saveUserDataUseCase: SaveUserDataUseCase) : ViewModel() {

    fun save(login: String, pass: String): Boolean {
        val param = SaveUserDataParam(login = login, pass = pass)
        return saveUserDataUseCase.execute(param = param)
    }
}