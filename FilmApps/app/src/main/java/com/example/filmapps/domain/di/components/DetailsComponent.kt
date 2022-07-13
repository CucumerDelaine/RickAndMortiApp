package com.example.filmapps.domain.di.components

import com.example.filmapps.domain.di.module.DetailsModule
import dagger.Component


@Component(modules = [DetailsModule::class])
interface DetailsComponent {
}