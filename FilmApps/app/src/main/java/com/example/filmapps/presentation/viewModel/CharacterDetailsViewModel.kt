package com.example.filmapps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.presentation.ui.ResultCharacterResponceModel
import com.example.filmapps.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.presentation.model.CharacterDetailsResult
import com.example.filmapps.presentation.model.CharacterDetailsResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    private val characterConverter: ResultCharacterResponceModel
) : ViewModel() {

    private val _mutableState: MutableStateFlow<CharacterDetailsResult> =
        MutableStateFlow(CharacterDetailsResult.Loading)
    val mutableState: StateFlow<CharacterDetailsResult> = _mutableState


    fun getCharacterDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val it = getCharacterDetailsUseCase.execute(id)) {
                is CharacterDetailsResponce.Success -> {
                    _mutableState.emit(CharacterDetailsResult.Success(characterConverter.converter(it.value)))
                }
                is CharacterDetailsResponce.Error -> {
                    _mutableState.emit(CharacterDetailsResult.Error(it.message.toString()))
                }
                is CharacterDetailsResponce.Loading -> {
                    _mutableState.emit(CharacterDetailsResult.Loading)
                }
            }
        }
    }
}