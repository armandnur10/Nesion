package com.example.nesion.presentation.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.RowItemNewsBinding
import com.example.nesion.presentation.detail.DetailActivity

class RecommendAdapter: RecyclerView.Adapter<RecommendAdapter.MyViewHolder>(){

    private var listRecommend = ArrayList<LazyResponse>()



    inner class MyViewHolder(val binding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listRecommend[position]
        holder.binding.apply {
            tvTitle.text = data.title
            tvCategory.text = data.tag
            Glide.with(ivImage.context).load(data.thumb).into(ivImage)
            holder.itemView.setOnClickListener{
                val intent = Intent(it.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.NEWS_DATA, listRecommend[position])
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = listRecommend.size

    fun setRecommend(data : List<LazyResponse>){
        listRecommend.clear()
        listRecommend.addAll(data)

    }

}