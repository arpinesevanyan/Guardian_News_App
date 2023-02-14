package com.arpinesevanyan.guardian.favorite.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arpinesevanyan.guardian.favorite.database.data.FavoriteNewsEntity

@Dao
interface FavoriteNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(entity: FavoriteNewsEntity)

    @Query("SELECT * FROM favorite_news_table")
    fun getAllNews(): LiveData<List<FavoriteNewsEntity>>

    @Query("DELETE FROM favorite_news_table WHERE id = :newsId")
    fun deleteNewsById(newsId: String)

    @Delete
    fun deleteNews(favoriteNews: FavoriteNewsEntity)
}
