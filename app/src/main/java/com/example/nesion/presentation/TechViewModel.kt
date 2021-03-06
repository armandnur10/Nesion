

package com.example.nesion.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nesion.data.remote.ApiConfig
import com.example.nesion.data.response.LazyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechViewModel :ViewModel() {

    private val lazyResponse = MutableLiveData<List<LazyResponse>>()

    fun news(){
        ApiConfig().getApiService().getNews().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
            }
        })

    }

    fun tip(){
        ApiConfig().getApiService().getTip().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
            }
        })
    }

    fun recommend(){
        ApiConfig().getApiService().getRecommend().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
            }
        })
    }

    fun search(search:String){
        ApiConfig().getApiService().getSearch(search).enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
            }
        })
    }


    fun getLazy() : LiveData<List<LazyResponse>> = lazyResponse
}
