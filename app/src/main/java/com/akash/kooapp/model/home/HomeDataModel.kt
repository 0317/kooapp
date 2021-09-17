package com.akash.kooapp.model.home

import com.google.gson.annotations.SerializedName

data class HomeDataModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("user_id")
    var user_id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("body")
    var body: String
)