package com.bins.data.repository

import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import kotlinx.coroutines.channels.ReceiveChannel

interface UserDataStore{
    suspend fun getRandomUsers(): ReceiveChannel<DataEntity<UserResponseEntity>>
}