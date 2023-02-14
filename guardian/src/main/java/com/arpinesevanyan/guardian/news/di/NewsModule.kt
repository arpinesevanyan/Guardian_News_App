package com.arpinesevanyan.guardian.news.di

import com.arpinesevanyan.common.network.createWebService
import com.arpinesevanyan.guardian.news.BaseNewsViewModel
import com.arpinesevanyan.guardian.news.GuardianConstants
import com.arpinesevanyan.guardian.news.api.NewsApi
import com.arpinesevanyan.guardian.news.repo.NewsRepository
import com.arpinesevanyan.guardian.news.repo.NewsRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun newsModule() = module {

    single { createWebService<NewsApi>(GuardianConstants.BASE_URL) }

    single<NewsRepository> { NewsRepositoryImpl(get()) }

    viewModel { BaseNewsViewModel(get()) }
}