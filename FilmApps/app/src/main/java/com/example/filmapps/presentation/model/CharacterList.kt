package com.example.filmapps.presentation.model

import com.example.filmapps.data.model.DataApi
import com.example.filmapps.presentation.viewModel.Character
import java.lang.Exception

sealed class CharacterList {
    class Success(val value: MutableList<Character>) : CharacterList()
    class Error(val message: String) : CharacterList()
    object Loading : CharacterList()
    object Finaly : CharacterList()
}