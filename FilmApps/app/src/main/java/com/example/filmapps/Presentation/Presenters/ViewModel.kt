package com.example.filmapps.Presentation.Presenters

import androidx.lifecycle.ViewModel
import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase

class SaveUserDataViewModel(private val saveUserDataUseCase: SaveUserDataUseCase) : ViewModel() {

    fun save(login: String, pass: String): String {
        val param = SaveUserDataParam(login = login, pass = pass)
        return if(saveUserDataUseCase.execute(param = param))
            "Успешная регистрация"
        else
            "Неудачная регистрация"
    }
}