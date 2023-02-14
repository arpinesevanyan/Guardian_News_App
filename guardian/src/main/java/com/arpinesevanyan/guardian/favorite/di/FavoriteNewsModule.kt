package com.arpinesevanyan.guardian.favorite.di

import com.arpinesevanyan.guardian.favorite.database.FavoriteDatabase
import com.arpinesevanyan.guardian.favorite.repo.FavoriteNewsRepository
import com.arpinesevanyan.guardian.favorite.repo.FavoriteNewsRepositoryImpl
import org.koin.dsl.module

val favoriteNewsModule = module {
    single { get<FavoriteDatabase>().favoriteNewsDao() }
    single<FavoriteNewsRepository> { FavoriteNewsRepositoryImpl(get()) }
}