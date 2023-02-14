package com.arpinesevanyan.guardian.news.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailsDto(
    @SerializedName("response")
    val response: DetailsResponseDto?
)

data class DetailsResponseDto(
    @SerializedName("content")
    val content: DetailsContentDto?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("userTier")
    val userTier: String?
) : Serializable

data class DetailsContentDto(
    @SerializedName("apiUrl")
    val apiUrl: String?,
    @SerializedName("fields")
    val fields: DetailsFieldsDto?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isHosted")
    val isHosted: Boolean?,
    @SerializedName("pillarId")
    val pillarId: String?,
    @SerializedName("pillarName")
    val pillarName: String?,
    @SerializedName("sectionId")
    val sectionId: String?,
    @SerializedName("sectionName")
    val sectionName: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("webPublicationDate")
    val webPublicationDate: String?,
    @SerializedName("webTitle")
    val webTitle: String?,
    @SerializedName("webUrl")
    val webUrl: String?
) : Serializable

data class DetailsFieldsDto(
    @SerializedName("body")
    val body: String?,
    @SerializedName("headline")
    val headline: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
) : Serializable