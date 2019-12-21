package com.bins.presentation.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * demo class to show how to create parsalabe in kotlin, pass via intent
 */
data class User( var id: Int = 0,
                 var fname: String? = null,
                 var lname: String? = null,
                 var mediumPhoto: String,
                 var largePhoto: String,
                 var gender: String? = null,
                 var location: String? = null,
                 var phone: String? = null,
                 var email: String? = null,
                 var dob: String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(mediumPhoto)
        parcel.writeString(largePhoto)
        parcel.writeString(gender)
        parcel.writeString(location)
        parcel.writeString(phone)
        parcel.writeString(email)
        parcel.writeString(dob)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}