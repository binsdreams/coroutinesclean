package com.bins.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*


@Entity(tableName = "userInformation")
data class UserData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @SerializedName("fname") var fname: String? = null,
    @SerializedName("lname") var lname: String? = null,
    @SerializedName("mediumPhoto") var mediumPhoto: String? = null,
    @SerializedName("largePhoto") var largePhoto: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("dob") var dob: String? = null)