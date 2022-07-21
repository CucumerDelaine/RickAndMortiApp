package com.example.filmapps.Presentation.Presenters

import androidx.lifecycle.ViewModel
import com.example.filmapps.domain.Entities.SaveUserDataParam
import com.example.filmapps.domain.UseCase.SaveUserDataUseCase
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SaveUserDataViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCase) : ViewModel() {

    fun save(login: String, pass: String): String {
        return if(saveUserDataUseCase.execute(param = SaveUserDataParam(login = login, pass = pass)))
            "Успешная регистрация"
        else
            "Неудачная регистрация"
    }
}