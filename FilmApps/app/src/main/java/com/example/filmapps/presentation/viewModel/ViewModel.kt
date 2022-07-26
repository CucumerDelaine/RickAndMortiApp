package com.example.filmapps.presentation.presenters

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.filmapps.R
import com.example.filmapps.domain.model.SaveUserDataParam
import com.example.filmapps.domain.useCase.SaveUserDataUseCaseImpl
import javax.inject.Inject


internal class SaveUserDataViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCaseImpl,
    private val context: Context
) : ViewModel() {

    fun save(login: String, pass: String): String {
        return if (saveUserDataUseCase.execute(
                param = SaveUserDataParam(
                    login = login,
                    pass = pass
                )
            )
        )
            "${context.getString(R.string.goodReg)}"
        else
            "${context.getString(R.string.badRed)}"
    }
    fun save2(login: String, pass: String): String {
        return if (saveUserDataUseCase.execute(
                param = SaveUserDataParam(
                    login = login,
                    pass = pass
                )
            )
        )
            "Успешная авторизация"
        else
            "Неудачная авторизация"
    }
}
