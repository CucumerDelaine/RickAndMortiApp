package com.example.filmapps.feature.characterList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.Screens
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.domain.useCase.ClearDatabaseUseCase
import com.example.filmapps.feature.characterList.domain.useCase.GetCharacterListUseCase
import com.example.filmapps.feature.characterList.domain.useCase.LoadCharacterListUseCase
import com.example.filmapps.feature.characterList.domain.useCase.SaveCharacterListUseCase
import com.example.filmapps.feature.characterList.data.model.CharacterListDatabaseModel
import com.example.filmapps.feature.characterList.presentation.model.CharacterListResult
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val loadCharacterListUseCase: LoadCharacterListUseCase,
    private val saveCharacterListUseCase: SaveCharacterListUseCase,
    private val clearDatabaseUseCase: ClearDatabaseUseCase,
    private val characterConverter: CharacterListDatabaseModel,
    private val router: Router
) : ViewModel() {


    private val _mutableState: MutableStateFlow<CharacterListResult> =
        MutableStateFlow(CharacterListResult.Loading)
    val mutableState: StateFlow<CharacterListResult> = _mutableState


    fun goToDetails(character: Character) {
        router.newChain(Screens.Details(character))
    }


    fun clearDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val getResult = getCharacterListUseCase.execute()) {
                is GetCharacterListResponse.Success -> clearDatabaseUseCase.execute(getResult.value)
                is GetCharacterListResponse.Error -> Unit
            }
        }
    }


    private suspend fun getCharacterList() {
        when (val getResult = getCharacterListUseCase.execute()) {
            is GetCharacterListResponse.Success -> _mutableState.emit(
                CharacterListResult.Success(getResult.value)
            )
            is GetCharacterListResponse.Error -> _mutableState.emit(
                CharacterListResult.Error(getResult.message)
            )
        }
    }

    private suspend fun saveCharacterList(characterList: List<Character>?) {
        when (val saveResult = saveCharacterListUseCase.execute(characterList)) {
            is SaveCharacterListResult.Success -> getCharacterList()
            is SaveCharacterListResult.Error -> _mutableState.emit(
                CharacterListResult.Error(saveResult.message)
            )
        }
    }

    fun loadCharacterList(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (page == 43)
                _mutableState.emit(CharacterListResult.Finally)
            else {
                when (val loadResult = loadCharacterListUseCase.execute(page)) {
                    is LoadCharacterListResponse.Success -> saveCharacterList(
                        characterConverter.converter(
                            loadResult.value?.results
                        )
                    )
                    is LoadCharacterListResponse.Error -> _mutableState.emit(
                        CharacterListResult.Error(
                            loadResult.message
                        )
                    )
                }
            }
        }
    }
}