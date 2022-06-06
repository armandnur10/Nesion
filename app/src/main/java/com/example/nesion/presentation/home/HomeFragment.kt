package com.example.nesion.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nesion.R
import com.example.nesion.data.remote.LazyResponse
import com.example.nesion.databinding.FragmentHomeBinding
import com.example.nesion.presentation.MainViewModel
import com.example.nesion.presentation.NewsAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding as FragmentHomeBinding

    private val homeViewModel by viewModels<MainViewModel>()

    private val homeAdapter by lazy { NewsAdapter() }

    private var _currentData: List<LazyResponse>? = null

    private val currentData get() = _currentData as List<LazyResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvNews.apply {
            homeViewModel.getLazy().observe(viewLifecycleOwner) {

            }
            adapter = homeAdapter

            layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)


        }
    }
}