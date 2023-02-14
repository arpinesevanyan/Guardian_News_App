package com.arpinesevanyan.guardian.news.api

import com.arpinesevanyan.guardian.news.data.ContentNewsDto
import com.arpinesevanyan.guardian.news.data.DetailsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsApi {

    @Headers("api-key:c4e8c6de-cdfa-42a9-a87d-ef9835041f5a")
    @GET("search?")
    fun getContentNews(
        @Query("page-size") pageNumber: Int,
        @Query("show-fields") showFields: String
    ): Call<ContentNewsDto>

    @Headers("api-key:c4e8c6de-cdfa-42a9-a87d-ef9835041f5a")
    @GET
    fun getNewsDetails(
        @Url url: String,
        @Query("show-fields") showFields: String
    ): Call<DetailsDto>
}