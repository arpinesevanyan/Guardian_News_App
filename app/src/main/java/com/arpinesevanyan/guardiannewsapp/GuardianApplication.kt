package com.arpinesevanyan.guardiannewsapp

import com.arpinesevanyan.common.base.BaseCommonApplication
import com.arpinesevanyan.guardian.favorite.database.module.roomModule
import com.arpinesevanyan.guardian.favorite.di.favoriteNewsModule
import com.arpinesevanyan.guardian.news.di.newsModule
import com.arpinesevanyan.guardiannewsapp.di.module.guardianModule
import org.koin.core.module.Module

class GuardianApplication : BaseCommonApplication() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun getKoinModules(): List<Module> = listOf(
        newsModule(),
        guardianModule,
        roomModule,
        favoriteNewsModule
    )

    companion object {
        lateinit var instance: GuardianApplication
    }

}