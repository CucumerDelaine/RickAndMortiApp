package com.example.filmapps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.domain.useCase.GetListCharacterUseCase
import com.example.filmapps.presentation.model.Request
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


    private val _mutableState: MutableStateFlow<Request> = MutableStateFlow(Request.Loading)
    val mutableState: StateFlow<Request> = _mutableState

    fun getCharacterList() {
        viewModelScope.launch(Dispatchers.IO) {
            _mutableState.emit(getListCharacterUseCase.execute())
        }
    }
}