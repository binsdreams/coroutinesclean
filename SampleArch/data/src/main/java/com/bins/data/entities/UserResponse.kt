package com.bins.data.entities

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("info") var info: Info? = null,
    @SerializedName("results") var results: List<Result> = emptyList()
)