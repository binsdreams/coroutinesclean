package com.bins.data.entities

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("title") var title: String? = null,
    @SerializedName("first") var first: String? = null,
    @SerializedName("last") var last: String? = null
)