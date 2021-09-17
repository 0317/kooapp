package com.akash.kooapp.remote.retrofit

import com.akash.kooapp.model.home.HomeResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiInterface {

    @GET("v1/posts")
    fun getPosts(): Call<HomeResponseModel>
}

