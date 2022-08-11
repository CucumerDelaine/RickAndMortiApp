package com.example.filmapps.presentation.model


sealed class CharacterList {
    class Success(val value: MutableList<Character>) : CharacterList()
    class Error(val message: String) : CharacterList()
    object Loading : CharacterList()
    object Finally : CharacterList()
}
