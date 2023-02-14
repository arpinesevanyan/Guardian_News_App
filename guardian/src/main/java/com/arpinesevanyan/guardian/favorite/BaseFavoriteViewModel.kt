package com.arpinesevanyan.guardian.favorite

import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.arpinesevanyan.common.base.BaseCommonViewModel
import com.arpinesevanyan.guardian.favorite.database.data.FavoriteNewsEntity
import com.arpinesevanyan.guardian.favorite.repo.FavoriteNewsRepository
import com.arpinesevanyan.guardian.news.data.DetailsContentDto
import com.arpinesevanyan.guardian.news.data.NewsFieldsDto
import com.arpinesevanyan.guardian.news.data.NewsResultDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


open class BaseFavoriteViewModel(private val repository: FavoriteNewsRepository) :
    BaseCommonViewModel() {

    val favoriteNews = Transformations.map(repository.getNews()) {
        it.map { entity ->
            NewsResultDto(
                id = entity.id,
                webTitle = entity.webTitle,
                sectionName = entity.sectionName,
                fields = NewsFieldsDto(thumbnail = entity.thumbnail)
            )
        }
    }

    fun saveNews(item: DetailsContentDto) =
        viewModelScope.launch(Dispatchers.IO) { repository.insertNews(item) }

    fun saveNews(item: NewsResultDto) =
        viewModelScope.launch(Dispatchers.IO) { repository.insertNews(item) }

    fun deleteNews(item: FavoriteNewsEntity) =
        viewModelScope.launch(Dispatchers.IO) { repository.deleteNews(item) }

    fun deleteNewsById(newsId: String) =
        viewModelScope.launch(Dispatchers.IO) { repository.deleteNewsById(newsId) }

}