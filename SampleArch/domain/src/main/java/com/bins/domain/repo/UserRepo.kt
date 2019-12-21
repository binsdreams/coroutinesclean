package com.bins.domain.repo

import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import kotlinx.coroutines.channels.ReceiveChannel

interface UserRepo {

    suspend fun getUsers(): ReceiveChannel<DataEntity<UserResponseEntity>>

}