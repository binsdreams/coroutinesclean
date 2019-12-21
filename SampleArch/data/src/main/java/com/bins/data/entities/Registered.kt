package com.bins.data.entities

import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("cell") var cell: String? = null
)