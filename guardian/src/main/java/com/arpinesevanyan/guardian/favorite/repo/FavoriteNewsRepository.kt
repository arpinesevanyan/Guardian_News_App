package com.arpinesevanyan.guardian.favorite.repo

import androidx.lifecycle.LiveData
import com.arpinesevanyan.guardian.favorite.database.dao.FavoriteNewsDao
import com.arpinesevanyan.guardian.favorite.database.data.FavoriteNewsEntity
import com.arpinesevanyan.guardian.news.data.DetailsContentDto
import com.arpinesevanyan.guardian.news.data.NewsResultDto

interface FavoriteNewsRepository {
    suspend fun insertNews(detailsContentDto: DetailsContentDto)

    suspend fun insertNews(newsResultDto: NewsResultDto)

    suspend fun deleteNewsById(newsId: String)

    suspend fun deleteNews(favoriteNews: FavoriteNewsEntity)

    fun getNews(): LiveData<List<FavoriteNewsEntity>>
}

class FavoriteNewsRepositoryImpl(private val dataBase: FavoriteNewsDao) : FavoriteNewsRepository {

    override suspend fun insertNews(detailsContentDto: DetailsContentDto) {
        detailsContentDto.id?.let {
            dataBase.insertNews(
                FavoriteNewsEntity(
                    id = detailsContentDto.id,
                    thumbnail = detailsContentDto.fields?.thumbnail,
                    webTitle = detailsContentDto.webTitle,
                    sectionName = detailsContentDto.sectionName,
                )
            )
        }
    }

    override suspend fun insertNews(newsResultDto: NewsResultDto) {
        newsResultDto.id?.let {
            dataBase.insertNews(
                FavoriteNewsEntity(
                    id = newsResultDto.id,
                    thumbnail = newsResultDto.fields?.thumbnail,
                    webTitle = newsResultDto.webTitle,
                    sectionName = newsResultDto.sectionName,
                )
            )
        }
    }


    override suspend fun deleteNewsById(newsId: String): Unit = dataBase.deleteNewsById(newsId)

    override suspend fun deleteNews(favoriteNews: FavoriteNewsEntity) =
        dataBase.deleteNews(favoriteNews)

    override fun getNews(): LiveData<List<FavoriteNewsEntity>> = dataBase.getAllNews()
}