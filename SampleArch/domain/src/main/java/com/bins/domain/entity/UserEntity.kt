package com.bins.domain.entity


data class UserEntity(
    var id: Int = 0,
    var fname: String? = null,
    var lname: String? = null,
    var photoUrl: String? = null,
    var largePhoto: String? = null,
    var gender: String? = null,
    var location: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var dob: String? = null)