package com.arpinesevanyan.common.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

inline fun <reified T> createWebService(baseUrl: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(createOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(T::class.java)
}

fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(60L, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor())
    .readTimeout(60L, TimeUnit.SECONDS)
    .build()

interface ResultCallback<T> {

    fun onSuccess(data: T)

    fun onError(msg: String) {}
}

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}


// TUTORIAL

fun usage() {
    val fakeResponse = "json object from code beauty"

    //testWithGenerics(fakeResponse)
    //val parsedResult = Gson().fromJson(jsonResponse, T::class.java)
    val parsedInlinedResult = Gson().fromJson(fakeResponse, Response::class.java)
}

fun test() {
    val fakeResponse = "json object from code beauty"
    val a = Gson().fromJson(fakeResponse, Response::class.java)
}

inline fun <reified T> testWithGenerics(jsonResponse: String): T {
    return Gson().fromJson(jsonResponse, T::class.java)
}

data class Response(val cars: List<Car>)

data class Car(val year: Int, val name: String)