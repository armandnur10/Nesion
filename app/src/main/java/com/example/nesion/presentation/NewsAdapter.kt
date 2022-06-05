package com.example.nesion.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nesion.R
import com.example.nesion.data.remote.LazyResponse
import com.example.nesion.databinding.RowItemNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){

    val listNews = ArrayList<LazyResponse>()

    inner class MyViewHolder(val binding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: NewsAdapter.MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply {
            tvTitle.text = data.title
            tvCategory.text = data.tag
            ivImage.setImageResource(R.drawable.bg_row_item)
        }
    }

    override fun getItemCount() = listNews.size

}