package com.arpinesevanyan.guardian.favorite.database.module

import androidx.room.Room
import com.arpinesevanyan.guardian.favorite.database.FavoriteDatabase
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(get(), FavoriteDatabase::class.java, "guardian_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}