package com.example.feature_details_impl.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.NavigationScreens
import com.example.feature_details_api.domain.GetCharacterDetailsUseCase
import com.example.feature_details_api.model.CharacterDetailsResponse
import com.example.feature_details_api.model.ResultCharacterResponseModel
import com.example.feature_details_impl.presentation.model.CharacterDetailsResult
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    private val characterConverter: ResultCharacterResponseModel,
    private val router: Router,
    private val screens: NavigationScreens
) : ViewModel() {

    private val _mutableState: MutableStateFlow<CharacterDetailsResult> =
        MutableStateFlow(CharacterDetailsResult.Loading)
    val mutableState: StateFlow<CharacterDetailsResult> =
        _mutableState

    fun backToCharLIst() {
        router.backTo(screens.listFilmScreen())
    }


    fun getCharacterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val it = getCharacterDetailsUseCase.execute(id)) {
                is CharacterDetailsResponse.Success -> _mutableState.emit(
                    CharacterDetailsResult.Success(
                        characterConverter.converter(it.value)
                    )
                )
                is CharacterDetailsResponse.Error -> _mutableState.emit(
                    CharacterDetailsResult.Error(
                        it.message.toString()
                    )
                )
            }
        }
    }
}