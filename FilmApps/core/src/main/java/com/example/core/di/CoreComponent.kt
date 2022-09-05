package com.example.core.di

import com.example.core.data.NavigationScreens
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class], dependencies = [NavigationScreens::class])
@Singleton
interface CoreComponent : CoreAppApi