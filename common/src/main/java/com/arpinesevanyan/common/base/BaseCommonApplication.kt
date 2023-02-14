package com.arpinesevanyan.common.base

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class BaseCommonApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Koin
        startKoin {
            androidContext(this@BaseCommonApplication)
            modules(getKoinModules())
        }
    }

    abstract fun getKoinModules(): List<Module>
}