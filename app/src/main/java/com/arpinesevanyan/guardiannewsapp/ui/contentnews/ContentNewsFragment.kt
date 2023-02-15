package com.arpinesevanyan.guardiannewsapp.ui.contentnews

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.common.base.BaseCommonFragment
import com.arpinesevanyan.guardiannewsapp.databinding.FragmentContentNewsBinding
import com.arpinesevanyan.guardiannewsapp.favoritesViewModel
import com.arpinesevanyan.guardiannewsapp.ui.adapter.NewsAdapter
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class ContentNewsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentContentNewsBinding
    lateinit var newsAdapter: NewsAdapter
    private val viewModel by lifecycleScope.viewModel<ContentNewsViewModel>(this)

    private lateinit var scrollListener: RecyclerView.OnScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getContentNews()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentNewsBinding.inflate(inflater, container, false)
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
                ContentNewsFragmentDirections.actionContentNewsFragmentToDetailsFragment(
                    it
                )
            )
        }
        binding.contentNewsRecyclerView.apply {
            adapter = newsAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeLiveData() {
        viewModel.resultsLiveData.observe(viewLifecycleOwner) { it ->
            it?.let { result ->
                newsAdapter.updateData(result)
            }
        }
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) {
            newsAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentNewsFragment()
    }
}