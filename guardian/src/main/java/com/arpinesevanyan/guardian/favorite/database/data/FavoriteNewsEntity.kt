package com.arpinesevanyan.guardian.favorite.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_news_table")
data class FavoriteNewsEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    var id: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String?,
    @ColumnInfo(name = "webTitle")
    var webTitle: String?,
    @ColumnInfo(name = "sectionName")
    var sectionName: String?
)