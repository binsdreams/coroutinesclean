package com.bins.data.entities

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("name") var name: Name? = null,
    @SerializedName("location") var location: Location? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("dob") var dob: Dob? = null,
    @SerializedName("registered") var registered: Registered? = null,
    @SerializedName("picture") var picture: Picture? = null
)