package com.arpinesevanyan.guardiannewsapp.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arpinesevanyan.common.base.BaseCommonFragment
import com.arpinesevanyan.guardiannewsapp.databinding.FragmentFavoriteBinding
import com.arpinesevanyan.guardiannewsapp.favoritesViewModel
import com.arpinesevanyan.guardiannewsapp.ui.adapter.NewsAdapter

class FavoriteFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentFavoriteBinding
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setupViews()
    }

    private fun setupViews() {
        newsAdapter = NewsAdapter {
            navigateFragment(
                FavoriteFragmentDirections.actionContentNewsFragmentToDetailsFragment(
                    it
                )
            )
        }
        binding.favoriteRecyclerView.apply {
            adapter = newsAdapter
        }
    }

    private fun observeLiveData() {
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) {
            newsAdapter.updateData(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavoriteFragment()
    }
}