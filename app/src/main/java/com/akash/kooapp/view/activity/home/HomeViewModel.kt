package com.akash.kooapp.view.activity.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akash.kooapp.model.home.HomeResponseModel
import com.akash.kooapp.remote.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    var categoryResponse = MutableLiveData<HomeResponseModel>()
    var categoryError = MutableLiveData<String>()

    fun getPostList(context: Context) {
        val apiService = ApiClient.getAPIInstance()

        val registerApiCall = apiService.getPosts()

        registerApiCall.enqueue(object : Callback<HomeResponseModel> {

            override fun onResponse(call: Call<HomeResponseModel>?, response: Response<HomeResponseModel>?) {
                if (response?.body() != null) {
                    categoryResponse.value = response.body()
                }
            }

            override fun onFailure(call: Call<HomeResponseModel>?, t: Throwable?) {
                categoryError.value = t.toString()
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
    }
}