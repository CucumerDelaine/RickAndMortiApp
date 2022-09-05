package com.example.feature_characterlist_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core.viewModel.ViewModelModule
import com.example.core_db_api.di.CoreDbApi
import com.example.core_network_api.di.CoreNetworkApi
import dagger.Component

@Component(
    modules = [CharacterListModule::class, ViewModelModule::class],
    dependencies = [CoreDbApi::class, CoreAppApi::class, CoreNetworkApi::class]
)
@CharacterListScope
interface CharacterListComponent : ViewModelApi
