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
import com.example.nesion.databinding.FragmentNewsBinding
import com.example.nesion.databinding.FragmentTipBinding
import com.example.nesion.presentation.TechViewModel
import com.example.nesion.presentation.home.adapter.NewsAdapter
import com.example.nesion.presentation.home.adapter.TipAdapter

class TipFragment : Fragment() {

    private lateinit var binding: FragmentTipBinding

    private val tipViewModel by viewModels<TechViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTipBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tipViewModel.tip()
        tipViewModel.getLazy().observe(viewLifecycleOwner){
            setupRecyclerView(it)
        }
    }

    private fun setupRecyclerView(data : List<LazyResponse>){
        binding.rvNews.apply {
            Log.i("DataLazy", "$data")
            val mAdapter = TipAdapter()
            mAdapter.setTip(data)
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }
}