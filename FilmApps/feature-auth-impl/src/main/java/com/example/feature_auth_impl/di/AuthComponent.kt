package com.example.feature_auth_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core.viewModel.ViewModelModule
import com.example.core_db_api.di.CoreDbApi
import com.example.feature_auth_api.di.AuthNavigationApi
import com.example.feature_characterlist_api.di.CharListApi
import com.example.feature_reg_api.di.RegApi
import dagger.Component

@Component(
    modules = [AuthModule::class, ViewModelModule::class],
    dependencies = [CoreDbApi::class, CoreAppApi::class, CharListApi::class, RegApi::class]
)
@AuthScope
interface AuthComponent : ViewModelApi


@Component(modules = [NavigationModule::class])
@AuthScope
interface AuthNavComponent : AuthNavigationApi
