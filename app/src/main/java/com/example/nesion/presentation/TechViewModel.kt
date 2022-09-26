

package com.example.nesion.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nesion.data.remote.ApiConfig
import com.example.nesion.data.response.LazyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechViewModel :ViewModel() {

    val lazyResponse = MutableLiveData<List<LazyResponse>>()

//    val isLoading = MutableLiveData(true)

    fun news(){
        ApiConfig().getApiService().getNews().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
//                isLoading.value = false
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
//                isLoading.value = false

            }
        })

    }

    fun tip(){
        ApiConfig().getApiService().getTip().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
//                isLoading.value = false

            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
//                isLoading.value = false

            }
        })
    }

    fun recommend(){
        ApiConfig().getApiService().getRecommend().enqueue(object : Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) lazyResponse.postValue(response.body())
//                isLoading.value = false

            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
//                isLoading.value = false

            }
        })
    }



    fun getLazy() : LiveData<List<LazyResponse>> = lazyResponse
}
