package com.example.feature_details_impl.presentation.model

import com.example.feature_details_api.model.CharacterDetailsUIModel

sealed class CharacterDetailsResult {
    class Success(val value: CharacterDetailsUIModel?) : CharacterDetailsResult()
    class Error(val message: String) : CharacterDetailsResult()
    object Loading : CharacterDetailsResult()
}