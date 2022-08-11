package com.example.filmapps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.data.model.Results
import com.example.filmapps.domain.useCase.GetListCharacterUseCase
import com.example.filmapps.presentation.model.Character
import com.example.filmapps.presentation.model.CharacterList
import com.example.filmapps.presentation.model.CharacterListResponce
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListCharacterViewModel @Inject constructor(
    private val getListCharacterUseCase: GetListCharacterUseCase,
    private val router: Router,
) : ViewModel() {


    private val _mutableState: MutableStateFlow<CharacterList> = MutableStateFlow(CharacterList.Loading)
    val mutableState: StateFlow<CharacterList> = _mutableState
    private val list : MutableList<Character> = ArrayList()

    fun getCharacterList() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val it = getListCharacterUseCase.execute()) {
                is CharacterListResponce.Success -> {
                    list.addAll(converter(it.value?.results))
                    _mutableState.emit(CharacterList.Success(list))
                }
                is CharacterListResponce.Error -> {
                    _mutableState.emit(CharacterList.Error(it.message.toString()))
                }
                is CharacterListResponce.Loading -> {
                    _mutableState.emit(CharacterList.Loading)
                }
                is CharacterListResponce.Finally -> CharacterList.Finally
            }
        }
    }

    private fun converter(values: ArrayList<Results>?): MutableList<Character> {
        val list : MutableList<Character> = ArrayList()
        if (values != null) {
            for (it in values)
                list.add(Character(it.id, it.image))
        }
        return list
    }
}