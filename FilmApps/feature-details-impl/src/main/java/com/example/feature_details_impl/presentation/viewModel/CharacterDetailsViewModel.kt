package com.example.feature_details_impl.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_characterlist_api.data.repository.CharacterListNavigationRepository
import com.example.feature_details_api.model.CharacterDetailsResponse
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: com.example.feature_details_api.domain.GetCharacterDetailsUseCase,
    private val characterConverter: com.example.feature_details_api.model.ResultCharacterResponseModel,
    private val router: Router,
    private val characterListNavigationRepository: CharacterListNavigationRepository
) : ViewModel() {

    private val _mutableState: MutableStateFlow<com.example.feature_details_impl.presentation.model.CharacterDetailsResult> =
        MutableStateFlow(com.example.feature_details_impl.presentation.model.CharacterDetailsResult.Loading)
    val mutableState: StateFlow<com.example.feature_details_impl.presentation.model.CharacterDetailsResult> =
        _mutableState

    fun backToCharLIst() {
        router.backTo(characterListNavigationRepository.getNewInstance())
    }


    fun getCharacterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val it = getCharacterDetailsUseCase.execute(id)) {
                is CharacterDetailsResponse.Success -> _mutableState.emit(
                    com.example.feature_details_impl.presentation.model.CharacterDetailsResult.Success(
                        characterConverter.converter(it.value)
                    )
                )
                is CharacterDetailsResponse.Error -> _mutableState.emit(
                    com.example.feature_details_impl.presentation.model.CharacterDetailsResult.Error(
                        it.message.toString()
                    )
                )
            }
        }
    }
}