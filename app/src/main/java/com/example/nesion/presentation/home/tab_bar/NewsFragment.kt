package com.example.nesion.presentation.home.tab_bar

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.FragmentNewsBinding
import com.example.nesion.presentation.TechViewModel
import com.example.nesion.presentation.home.adapter.NewsAdapter

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    private val newsViewModel by viewModels<TechViewModel>()

    private val viewModel: TechViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.news()
        newsViewModel.getLazy().observe(viewLifecycleOwner){
            setupRecyclerView(it)
            setupBindings()
        }
    }



    private fun setupRecyclerView(data : List<LazyResponse>){
        binding.rvNews.apply {
            Log.i("DataLazy", "$data")
            val mAdapter = NewsAdapter()
            mAdapter.setNews(data)
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }

    private fun setupBindings(){
        if (viewModel.lazyResponse.value == null) viewModel.getLazy()
        viewModel.isLoading.observe(viewLifecycleOwner){showLoading(it)}
    }

    private fun showLoading(isLoading: Boolean) {
        binding.apply {
            pgBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            rvNews.visibility = if (isLoading) View.GONE else View.VISIBLE
        }
    }
}