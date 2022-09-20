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

class SearchViewModel: ViewModel() {

    val listSearch = MutableLiveData<List<LazyResponse>>()

    fun search(search:String){
        ApiConfig().getApiService().getSearch(search).enqueue(object :
            Callback<List<LazyResponse>> {
            override fun onResponse(call: Call<List<LazyResponse>>, response: Response<List<LazyResponse>>) {
                if (response.isSuccessful) listSearch.postValue(response.body())
            }

            override fun onFailure(call: Call<List<LazyResponse>>, t: Throwable) {
                Log.e("SearchNews", "OnFailure: $t")
            }
        })
    }

    fun getSearchNews() : LiveData<List<LazyResponse>> = listSearch

}