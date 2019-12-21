package com.bins.data.repository

import com.bins.data.api.RandomUserApi
import com.bins.data.mappers.ResDataEntityMapper
import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.ErrorEntity
import com.bins.domain.entity.UserResponseEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import java.lang.Exception

class UserRemoteRepoImpl constructor(private val api: RandomUserApi) : UserDataStore {

    private val responseToEntityMapper = ResDataEntityMapper()

    override suspend fun getRandomUsers(): ReceiveChannel<DataEntity<UserResponseEntity>> {

        val producer = GlobalScope.produce<DataEntity<UserResponseEntity>> {
            try {
                val randomUsers = api.getRandomUsers().await()
                responseToEntityMapper.mapToEntity(randomUsers.results).let { send(DataEntity.SUCCESS(it)) }
            } catch (e: Exception) {
                send(DataEntity.ERROR(ErrorEntity(e.message)))
            }
        }
        return producer
    }

}