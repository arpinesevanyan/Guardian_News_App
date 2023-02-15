package com.arpinesevanyan.guardiannewsapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.arpinesevanyan.common.base.BaseCommonActivity
import com.arpinesevanyan.guardian.favorite.BaseFavoriteViewModel
import com.arpinesevanyan.guardiannewsapp.R
import com.arpinesevanyan.guardiannewsapp.databinding.ActivityNewsBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class NewsActivity : BaseCommonActivity() {
    private lateinit var binding: ActivityNewsBinding
    override fun noInternetView(): View = binding.noInternetTextView
    val favoriteViewModel by lifecycleScope.viewModel<BaseFavoriteViewModel>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(this.findNavController(R.id.navHostFragment))

    }
}