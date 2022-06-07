package com.example.nesion.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.example.nesion.R
import com.example.nesion.databinding.ActivityMainBinding
import com.example.nesion.databinding.FragmentHomeBinding
import com.example.nesion.presentation.TechViewModel
import com.example.nesion.presentation.home.adapter.SectionPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val viewModel : TechViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding.vpNews.adapter= SectionPagerAdapter(this.activity as FragmentActivity)
        binding.toolbar.elevation = 0f
        binding.appBar.elevation = 0f

        viewModel.lazy()

        val tablist = arrayOf("News", "Tip", "Recommend")
        TabLayoutMediator(binding.tabs, binding.vpNews){
                tab, position -> tab.text = tablist[position]
        }.attach()
        return binding.root
    }


}