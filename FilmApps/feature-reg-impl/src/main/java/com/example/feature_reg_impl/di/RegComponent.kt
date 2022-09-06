package com.example.feature_reg_impl.di


import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core.viewModel.ViewModelModule
import com.example.core_db_api.di.CoreDbApi
import dagger.Component

@Component(
    modules = [RegModule::class, ViewModelModule::class],
    dependencies = [CoreDbApi::class, CoreAppApi::class]
)
@RegScope
interface RegComponent: ViewModelApi