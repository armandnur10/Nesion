package com.example.nesion.presentation.home.tab_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesion.data.remote.LazyResponse
import com.example.nesion.databinding.FragmentHomeBinding
import com.example.nesion.presentation.NewsAdapter

class HomeFragment: Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val bind get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        bind.rvNews.apply {
            val mAdapter = NewsAdapter()
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
        return bind.root

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}