package com.example.nesion.presentation.home.tab_bar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.FragmentRecommendBinding
import com.example.nesion.presentation.TechViewModel
import com.example.nesion.presentation.home.adapter.RecommendAdapter

class RecommendFragment : Fragment() {
    private lateinit var binding: FragmentRecommendBinding

    private val recommendViewModel by viewModels<TechViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecommendBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recommendViewModel.recommend()
        recommendViewModel.getLazy().observe(viewLifecycleOwner){
            setupRecyclerView(it)
        }
    }

    private fun setupRecyclerView(data : List<LazyResponse>){
        binding.rvNews.apply {
            Log.i("DataLazy", "$data")
            val mAdapter = RecommendAdapter()
            mAdapter.setRecommend(data)
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }
}