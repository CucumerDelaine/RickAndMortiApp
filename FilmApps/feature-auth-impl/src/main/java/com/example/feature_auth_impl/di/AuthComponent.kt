package com.example.feature_auth_impl.di

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core.viewModel.ViewModelModule
import com.example.core_db_api.di.CoreDbApi
import dagger.Component

@Component(
    modules = [AuthModule::class, ViewModelModule::class],
    dependencies = [CoreDbApi::class, CoreAppApi::class]
)
@AuthScope
interface AuthComponent : ViewModelApi
