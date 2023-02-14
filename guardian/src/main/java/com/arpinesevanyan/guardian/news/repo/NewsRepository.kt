package com.arpinesevanyan.guardian.news.repo

import com.arpinesevanyan.common.network.ResultCallback
import com.arpinesevanyan.guardian.news.api.NewsApi
import com.arpinesevanyan.guardian.news.data.ContentNewsDto
import com.arpinesevanyan.guardian.news.data.DetailsDto
import com.arpinesevanyan.guardian.news.model.ShowFieldsEnum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NewsRepository {
    fun getContentNews(
        pageNumber: Int,
        showFieldsEnum: ShowFieldsEnum,
        resultCallback: ResultCallback<ContentNewsDto?>
    )

    fun getDetails(
        newsId: String,
        showFieldsEnum: String,
        resultCallback: ResultCallback<DetailsDto?>
    )
}

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override fun getContentNews(
        pageNumber: Int,
        showFieldsEnum: ShowFieldsEnum,
        resultCallback: ResultCallback<ContentNewsDto?>
    ) {
        newsApi.getContentNews(pageNumber = pageNumber, showFields = showFieldsEnum.fields)
            .enqueue(object : Callback<ContentNewsDto> {

                override fun onResponse(
                    call: Call<ContentNewsDto>,
                    response: Response<ContentNewsDto>
                ) {
                    if (response.isSuccessful) {
                        resultCallback.onSuccess(response.body())
                    } else {
                        resultCallback.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<ContentNewsDto>, t: Throwable) {
                    resultCallback.onError(t.message ?: "unknown failure")
                }
            })
    }

    override fun getDetails(
        newsId: String,
        showFieldsEnum: String,
        resultCallback: ResultCallback<DetailsDto?>
    ) {
        newsApi.getNewsDetails(url = newsId, showFields = showFieldsEnum)
            .enqueue(object : Callback<DetailsDto> {

                override fun onResponse(call: Call<DetailsDto>, response: Response<DetailsDto>) {
                    if (response.isSuccessful) {
                        resultCallback.onSuccess(response.body())
                    } else {
                        resultCallback.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<DetailsDto>, t: Throwable) {
                    resultCallback.onError(t.message ?: "unknown failure")
                }
            })
    }

}