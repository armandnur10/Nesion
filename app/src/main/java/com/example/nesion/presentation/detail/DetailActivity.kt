package com.example.nesion.presentation.detail

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.ActivityDetailBinding
import com.google.android.material.appbar.CollapsingToolbarLayout

class DetailActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        

        val data = intent.getParcelableExtra<LazyResponse>(NEWS_DATA) as LazyResponse
        Glide.with(this).load(data.thumb).into(binding.ivImage)
        binding.apply {
            tvTitle.text = data.title
            tvDate.text = data.time
            tvCategory.text = data.tag
            tvDescription.text = data.desc
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


    companion object{
        const val NEWS_DATA = "0"
    }

}