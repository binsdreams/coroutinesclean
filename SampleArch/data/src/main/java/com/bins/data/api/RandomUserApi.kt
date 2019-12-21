package com.bins.data.api

import com.bins.data.entities.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RandomUserApi{

    @GET("api?/page=1&results=10")
    fun getRandomUsers(): Deferred<UserResponse>

}