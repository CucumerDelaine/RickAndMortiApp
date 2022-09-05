package com.example.feature_details_impl.di.component

import com.example.core.di.CoreAppApi
import com.example.core.viewModel.ViewModelApi
import com.example.core.viewModel.ViewModelModule
import com.example.core_db_api.di.CoreDbApi
import com.example.feature_details_impl.di.module.DetailsModule
import com.example.feature_details_impl.di.scope.DetailsScope
import dagger.Component


@Component(
    modules = [DetailsModule::class, ViewModelModule::class],
    dependencies = [CoreDbApi::class, CoreAppApi::class]
)
@DetailsScope
interface DetailsComponent : ViewModelApi