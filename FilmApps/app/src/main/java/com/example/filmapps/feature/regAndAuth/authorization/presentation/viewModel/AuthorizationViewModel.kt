package com.example.filmapps.feature.regAndAuth.authorization.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.filmapps.R
import com.example.filmapps.Screens
import com.example.filmapps.feature.regAndAuth.Result
import com.example.filmapps.feature.regAndAuth.authorization.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

internal class AuthorizationViewModel @Inject constructor(
    private val getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCase,
    private val router: Router,
    private val context: Context
) : ViewModel() {

    fun goToMain() {
        router.backTo(Screens.RegistrationScreen())
    }

    fun goToFilm() {
        router.newChain(Screens.ListFilmScreen())
    }

    fun auth(login: String, pass: String): Result {
        return if (getInfoAboutRegisterUseCase.execute(
                param = UserDataParam(
                    login = login,
                    pass = pass
                )
            )
        )
            Result.Success
        else
            Result.Error("${context.getString(R.string.badAuth)}")
    }
}