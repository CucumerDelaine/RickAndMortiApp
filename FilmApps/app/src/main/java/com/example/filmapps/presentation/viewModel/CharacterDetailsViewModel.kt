package com.example.filmapps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.data.model.ResultCharacterApi
import com.example.filmapps.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.presentation.model.CharacterDetails
import com.example.filmapps.presentation.model.CharacterDetailsResponce
import com.example.filmapps.presentation.model.ConvertCharacterDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {

    private val _mutableState: MutableStateFlow<CharacterDetails> =
        MutableStateFlow(CharacterDetails.Loading)
    val mutableState: StateFlow<CharacterDetails> = _mutableState


    fun getCharacterDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val it = getCharacterDetailsUseCase.execute(id)) {
                is CharacterDetailsResponce.Success -> {
                    _mutableState.emit(converter(it.value))
                }
                is CharacterDetailsResponce.Error -> {
                    _mutableState.emit(CharacterDetails.Error(it.message.toString()))
                }
                is CharacterDetailsResponce.Loading -> {
                    _mutableState.emit(CharacterDetails.Loading)
                }
            }
        }
    }

    private fun converter(values: ResultCharacterApi?): CharacterDetails {
        return if (values != null) {
            val character: ConvertCharacterDetails = ConvertCharacterDetails(
                values.name,
                values.status,
                values.species,
                values.gender,
                values.origin?.name,
                values.location?.name,
                values.image
            )
            CharacterDetails.Success(character)
        } else
            CharacterDetails.Error("Пустое поле")
    }
}