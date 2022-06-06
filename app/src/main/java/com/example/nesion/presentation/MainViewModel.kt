package com.example.nesion.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nesion.data.remote.ApiConfig
import com.example.nesion.data.remote.LazyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel() {

    private val lazyResponse = MutableLiveData<List<LazyResponse>>()

    fun lazy(){
        ApiConfig().getApiService().getGames().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getLazy() : LiveData<List<LazyResponse>> = lazyResponse
}