package com.example.filmapps.presentation.presenters

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.filmapps.R
import com.example.filmapps.Result
import com.example.filmapps.Screens
import com.example.filmapps.domain.model.UserDataParam
import com.example.filmapps.domain.useCase.SaveUserDataUseCase
import com.github.terrakok.cicerone.Router
import javax.inject.Inject


internal class SaveUserDataViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCase,
    private val router: Router,
    private val context: Context
) : ViewModel() {

    fun goToAuth() {
        router.newChain(Screens.AuthorizationScreen())
    }

    fun registration(login: String, pass: String): Result {
        return if (saveUserDataUseCase.execute(param = UserDataParam(login = login, pass = pass)))
            Result.Success
        else {
            Result.Error("${context.getString(R.string.badRed)}")
        }
    }
}