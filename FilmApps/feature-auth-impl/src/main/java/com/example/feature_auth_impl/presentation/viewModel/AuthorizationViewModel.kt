package com.example.feature_auth_impl.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_auth_api.domain.GetInfoAboutRegisterUseCase
import com.example.feature_auth_api.model.AuthResult
import com.example.feature_auth_api.model.UserData
import com.example.feature_auth_impl.presentation.model.AuthResultUI
import com.example.feature_characterlist_api.data.repository.CharacterListNavigationRepository
import com.example.feature_reg_api.data.RegNavigationRepository
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class AuthorizationViewModel @Inject constructor(
    private val getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCase,
    private val router: Router,
    private val regRepository: RegNavigationRepository,
    private val charListRepository: CharacterListNavigationRepository
) : ViewModel() {


    private val _mutableState: MutableStateFlow<AuthResultUI> =
        MutableStateFlow(AuthResultUI.Loading)
    val mutableState: StateFlow<AuthResultUI> = _mutableState

    fun goToMain() {
        router.navigateTo(regRepository.getNewInstance())
    }

    private fun goToFilm() {
        router.navigateTo(charListRepository.getNewInstance())
    }

    fun auth(login: String, pass: String) {
        viewModelScope.launch {
            when (val it = getInfoAboutRegisterUseCase.execute(
                param = UserData(
                    login = login,
                    pass = pass
                )
            )
            ) {
                is AuthResult.Success -> {
                    _mutableState.emit(AuthResultUI.Success)
                    goToFilm()
                }
                is AuthResult.Error -> _mutableState.emit(AuthResultUI.Error(it.message))
                is AuthResult.EmptyError -> _mutableState.emit(AuthResultUI.EmptyError)
            }
        }
    }
}