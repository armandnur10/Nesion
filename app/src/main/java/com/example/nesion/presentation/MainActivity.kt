package com.example.nesion.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.nesion.R
import com.example.nesion.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.vpNews.adapter= SectionPagerAdapter(this)
        binding.toolbar.elevation = 0f
        binding.appBar.elevation = 0f

        val tablist = arrayOf("News", "Tip", "Recommend")
        TabLayoutMediator(binding.tabs, binding.vpNews){
                tab, position -> tab.text = tablist[position]
        }.attach()
    }
}