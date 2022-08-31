package com.example.feature_characterlist_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core.viewModel.ViewModelModule
import com.example.core_db_api.di.CoreDbApi
import com.example.core_network_api.di.CoreNetworkApi
import com.example.feature_characterlist_api.di.CharListApi
import com.example.feature_details_api.di.DetailsApi
import dagger.Component

@Component(
    modules = [CharacterListModule::class, ViewModelModule::class],
    dependencies = [CoreDbApi::class, CoreAppApi::class, CoreNetworkApi::class, DetailsApi::class]
)
@CharacterListScope
interface CharacterListComponent : ViewModelApi


@Component(
    modules = [NavigationModule::class]
)
@CharacterListScope
interface CharacterListNavigationComponent : CharListApi
