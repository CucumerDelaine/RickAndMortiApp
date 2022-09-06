package com.example.core.di

import android.content.Context
import com.example.core.data.NavigationScreens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface CoreAppApi {

    fun getRouter(): Router
    fun getContext(): Context
    fun getNavigatorHolder(): NavigatorHolder
    fun getScreens(): NavigationScreens
}