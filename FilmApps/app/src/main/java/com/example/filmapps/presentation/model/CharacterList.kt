package com.example.filmapps.presentation.model

import com.example.filmapps.presentation.viewModel.Character

sealed class CharacterList {
    class Success(val value: MutableList<Character>) : CharacterList()
    class Error(val message: String) : CharacterList()
    object Loading : CharacterList()
}
