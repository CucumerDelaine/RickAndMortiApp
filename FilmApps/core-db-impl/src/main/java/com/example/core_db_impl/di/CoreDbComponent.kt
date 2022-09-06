package com.example.core_db_impl.di


import com.example.core.di.CoreAppApi
import com.example.core_db_api.di.CoreDbApi
import dagger.Component

@Component(modules = [DbModule::class, DbModuleBinds::class], dependencies = [CoreAppApi::class])
@CoreDbScope
interface CoreDbComponent : CoreDbApi