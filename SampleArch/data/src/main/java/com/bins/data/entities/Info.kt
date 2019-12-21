package com.bins.data.entities

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("results") var results: String? = null,
    @SerializedName("page") var page: String? = null
)