package com.example.nesion.data.remote

import com.example.nesion.data.response.LazyResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("tech")
    fun getTech() : Call<List<LazyResponse>>
}