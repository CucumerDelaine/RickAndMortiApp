package com.example.filmapps.presentation.model

import com.example.filmapps.data.model.DataApi
import java.lang.Exception

sealed class Request {
    class Success(val value: DataApi?) : Request()
    class Error(val message: Exception) : Request()
    object Loading : Request()
}
