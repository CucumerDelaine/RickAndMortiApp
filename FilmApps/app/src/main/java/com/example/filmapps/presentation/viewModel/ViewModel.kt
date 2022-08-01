package com.example.filmapps.presentation.presenters

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.filmapps.R
import com.example.filmapps.Screens
import com.example.filmapps.domain.model.SaveUserDataParam
import com.example.filmapps.domain.useCase.SaveUserDataUseCase
import com.github.terrakok.cicerone.Router
import javax.inject.Inject


internal class SaveUserDataViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCase,
    private val router: Router,
    private val context: Context
) : ViewModel() {

    fun goToMain() {
       router.backTo(Screens.Main())
    }

    fun goToAuth(){
        router.newChain(Screens.AddressSearch())
    }


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
}
