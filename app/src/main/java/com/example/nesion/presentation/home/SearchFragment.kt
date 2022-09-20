package com.example.nesion.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesion.R
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.FragmentRecommendBinding
import com.example.nesion.databinding.FragmentSearchBinding
import com.example.nesion.presentation.SearchViewModel
import com.example.nesion.presentation.TechViewModel
import com.example.nesion.presentation.home.adapter.NewsAdapter
import com.example.nesion.presentation.home.adapter.RecommendAdapter
import com.example.nesion.presentation.home.adapter.SearchAdapter

class SearchFragment : Fragment(){

    private var _binding : FragmentSearchBinding? = null
    private val binding get() = _binding as FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        _binding = FragmentSearchBinding.inflate(layoutInflater)
        binding.btnBackSearch.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_homeFragment)
        }

        binding.btnSearch.setOnClickListener {
            viewModel.search(binding.textInputSearch.text.toString())
            viewModel.apply {
                getSearchNews()
                listSearch.observe(viewLifecycleOwner) {
                    showData(it)
                }

            }
        }

        viewModel.listSearch.observe(viewLifecycleOwner) {
            Log.i("DataNews", "onCreate : terbuat")
            println(it[0].title)
        }

        return binding.root
    }

    private fun showData(data: List<LazyResponse>?) {

        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = data?.let { SearchAdapter(it) }
        }

    }

}

