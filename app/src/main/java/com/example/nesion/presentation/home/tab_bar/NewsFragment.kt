package com.example.nesion.presentation.home.tab_bar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesion.databinding.FragmentNewsBinding
import com.example.nesion.presentation.home.adapter.NewsAdapter

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = NewsAdapter()

            return binding.root
        }

    }
}