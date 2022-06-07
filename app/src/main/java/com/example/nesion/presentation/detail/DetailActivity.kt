package com.example.nesion.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<LazyResponse>(NEWS_DATA) as LazyResponse

        Glide.with(this).load(data.thumb).into(binding.ivImage)
        binding.apply {
            tvTitle.text = data.title
            tvDate.text = data.time
            tvDescription.text = data.desc
        }
    }



    companion object{
        const val NEWS_DATA = "0"
    }
}