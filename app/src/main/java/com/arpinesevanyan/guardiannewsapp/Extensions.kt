package com.arpinesevanyan.guardiannewsapp

import androidx.fragment.app.Fragment
import com.arpinesevanyan.guardian.favorite.BaseFavoriteViewModel
import com.arpinesevanyan.guardiannewsapp.ui.activity.NewsActivity

val Fragment.newsActivity: NewsActivity?
    get() = activity as? NewsActivity

val Fragment.favoritesViewModel: BaseFavoriteViewModel?
    get() = newsActivity?.favoriteViewModel