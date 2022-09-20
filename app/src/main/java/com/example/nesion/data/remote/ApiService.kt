package com.example.nesion.data.remote

import androidx.constraintlayout.helper.widget.Flow
import com.example.nesion.data.response.LazyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("tech/news")
    fun getNews(): Call<List<LazyResponse>>

    @GET("tech/tip")
    fun getTip(): Call<List<LazyResponse>>

    @GET("tech/recommend")
    fun getRecommend(): Call<List<LazyResponse>>

    @GET("search")
    fun getSearch(
        @Query("search") search: String
    ): Call<List<LazyResponse>>
}

