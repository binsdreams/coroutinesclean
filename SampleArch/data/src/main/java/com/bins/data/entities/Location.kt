package com.bins.data.entities

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city") var city: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("postcode") var postcode: String? = null
)