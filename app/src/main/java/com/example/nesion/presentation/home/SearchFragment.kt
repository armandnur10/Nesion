package com.example.nesion.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesion.R
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.FragmentRecommendBinding
import com.example.nesion.databinding.FragmentSearchBinding
import com.example.nesion.presentation.TechViewModel
import com.example.nesion.presentation.home.adapter.NewsAdapter
import com.example.nesion.presentation.home.adapter.RecommendAdapter

class SearchFragment : Fragment(), androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentSearchBinding

    private val searchViewModel by viewModels<TechViewModel>()


    private val newsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSearchBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        searchViewModel.news()
        searchViewModel.getLazy().observe(viewLifecycleOwner) {
            setupRecyclerView(it)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {1
        inflater.inflate(R.menu.menu_item, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val search = menu.findItem(R.id.search_action)
        val searchAction = search.actionView as? SearchView
        searchAction?.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            searchViewModel.search(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return false
    }

}

