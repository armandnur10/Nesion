package com.example.nesion.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("tech")
    fun getTech() : Call<List<LazyResponse>>
}