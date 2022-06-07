package com.example.nesion.presentation.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nesion.presentation.home.tab_bar.NewsFragment
import com.example.nesion.presentation.home.tab_bar.RecommendFragment
import com.example.nesion.presentation.home.tab_bar.TipFragment

class SectionPagerAdapter(fa : FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> NewsFragment()
            1 -> TipFragment()
            2 -> RecommendFragment()
            else -> NewsFragment()
        }
    }

}