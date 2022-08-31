package com.example.feature_reg_impl.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_auth_api.data.AuthNavigationRepository
import com.example.feature_reg_api.domain.SaveUserDataUseCase
import com.example.feature_reg_api.model.RegResult
import com.example.feature_reg_api.model.UserData
import com.example.feature_reg_impl.presentation.model.RegResultUI
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class SaveUserDataViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCase,
    private val router: Router,
    private val authNavigateRepo: AuthNavigationRepository
) : ViewModel() {

    private val _mutableState: MutableStateFlow<RegResultUI> = MutableStateFlow(
        RegResultUI.Loading
    )
    val mutableState: StateFlow<RegResultUI> = _mutableState

    fun goToAuth() {
        router.backTo(authNavigateRepo.getNewInstance())
    }

    fun registration(login: String, pass: String) {
        viewModelScope.launch {
            when (val it =
                saveUserDataUseCase.execute(param = UserData(login = login, pass = pass))) {
                is RegResult.Success -> {
                    _mutableState.emit(RegResultUI.Success)
                    goToAuth()
                }
                is RegResult.Error -> _mutableState.emit(RegResultUI.Error(it.message))
                is RegResult.EmptyError -> _mutableState.emit(RegResultUI.EmptyError)
            }
        }
    }
}