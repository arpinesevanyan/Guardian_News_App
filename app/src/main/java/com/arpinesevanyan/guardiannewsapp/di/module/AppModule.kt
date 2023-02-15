package com.arpinesevanyan.guardiannewsapp.di.module

import com.arpinesevanyan.guardian.favorite.BaseFavoriteViewModel
import com.arpinesevanyan.guardiannewsapp.ui.activity.NewsActivity
import com.arpinesevanyan.guardiannewsapp.ui.contentnews.ContentNewsFragment
import com.arpinesevanyan.guardiannewsapp.ui.contentnews.ContentNewsViewModel
import com.arpinesevanyan.guardiannewsapp.ui.details.DetailsFragment
import com.arpinesevanyan.guardiannewsapp.ui.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val guardianModule = module {

    scope(named<NewsActivity>()) {
        viewModel { BaseFavoriteViewModel(get()) }
    }

    scope(named<ContentNewsFragment>()) {
        viewModel { ContentNewsViewModel(get()) }
    }
    scope(named<DetailsFragment>()) {
        viewModel { DetailsViewModel(get()) }
    }
}