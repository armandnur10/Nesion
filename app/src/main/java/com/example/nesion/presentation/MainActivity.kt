package com.example.nesion.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.nesion.databinding.ActivityMainBinding
import com.example.nesion.presentation.home.adapter.SectionPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel : TechViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.vpNews.adapter= SectionPagerAdapter(this)
        binding.toolbar.elevation = 0f
        binding.appBar.elevation = 0f

        viewModel.lazy()

        val tablist = arrayOf("News", "Tip", "Recommend")
        TabLayoutMediator(binding.tabs, binding.vpNews){
                tab, position -> tab.text = tablist[position]
        }.attach()
    }
}