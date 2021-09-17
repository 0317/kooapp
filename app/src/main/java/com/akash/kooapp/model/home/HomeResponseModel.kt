package com.akash.kooapp.model.home

import com.google.gson.annotations.SerializedName

data class HomeResponseModel(
    @SerializedName("data")
    var data: List<HomeDataModel>
)