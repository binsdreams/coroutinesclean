package com.bins.domain.entity


data class UserResponseEntity(
    var count: Int = 0,
    var page: String? = null,
    var results: List<UserEntity> = emptyList()
)