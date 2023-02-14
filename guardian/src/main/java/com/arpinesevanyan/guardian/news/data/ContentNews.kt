package com.arpinesevanyan.guardian.news.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ContentNewsDto(
    @SerializedName("response") val response: NewsResponseDto? = null
) : Serializable

data class NewsResponseDto(
    @SerializedName("currentPage") val currentPage: Int? = null,
    @SerializedName("orderBy") val orderBy: String? = null,
    @SerializedName("pageSize") val pageSize: Int? = null,
    @SerializedName("pages") val pages: Int? = null,
    @SerializedName("results") val results: MutableList<NewsResultDto?>? = null,
    @SerializedName("startIndex") val startIndex: Int? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("userTier") val userTier: String? = null
) : Serializable

data class NewsResultDto(
    @SerializedName("apiUrl") val apiUrl: String? = null,
    @SerializedName("fields") val fields: NewsFieldsDto? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("isHosted") val isHosted: Boolean? = null,
    @SerializedName("pillarId") val pillarId: String? = null,
    @SerializedName("pillarName") val pillarName: String? = null,
    @SerializedName("sectionId") val sectionId: String? = null,
    @SerializedName("sectionName") val sectionName: String? = null,
    @SerializedName("tags") val tags: List<NewsTagDto?>? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("webPublicationDate") val webPublicationDate: String? = null,
    @SerializedName("webTitle") val webTitle: String? = null,
    @SerializedName("webUrl") val webUrl: String? = null
) : Serializable

data class NewsFieldsDto(
    @SerializedName("headline") val headline: String? = null,
    @SerializedName("shortUrl") val shortUrl: String? = null,
    @SerializedName("starRating") val starRating: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null
) : Serializable

data class NewsTagDto(
    @SerializedName("apiUrl") val apiUrl: String? = null,
    @SerializedName("bio:") val bio: String? = null,
    @SerializedName("bylineImageUrl") val bylineImageUrl: String? = null,
    @SerializedName("bylineLargeImageUrl") val bylineLargeImageUrl: String? = null,
    @SerializedName("firstName") val firstName: String? = null,
    @SerializedName("id: String?") val id: String? = null,
    @SerializedName("lastName") val lastName: String? = null,
    @SerializedName("references") val references: List<Any?>? = null,
    @SerializedName("sectionId") val sectionId: String? = null,
    @SerializedName("sectionName") val sectionName: String? = null,
    @SerializedName("twitterHandle") val twitterHandle: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("webTitle") val webTitle: String? = null,
    @SerializedName("webUrl") val webUrl: String? = null
) : Serializable