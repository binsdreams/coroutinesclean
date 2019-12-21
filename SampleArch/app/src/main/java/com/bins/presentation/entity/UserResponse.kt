package com.bins.presentation.entity


data class UserResponse(
    var count: Int = 0,
    var page: String? = null,
    var results: List<User> = emptyList()
)