package com.bins.data.repository

import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import com.bins.domain.repo.UserRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

class UserRepositoryImpl(private val remote: UserRemoteRepoImpl,
                         private val cache: UserCacheImpl) : UserRepo {


    override suspend fun getUsers(): ReceiveChannel<DataEntity<UserResponseEntity>> {
        val producerChannel = GlobalScope.produce() {

            launch {
                val localNewsChannel = cache.getRandomUsers()
                localNewsChannel.consumeEach { send(it) }
            }

            launch {
                val remoteNews = remote.getRandomUsers().receive()
                when (remoteNews) {
                    is DataEntity.SUCCESS -> {
                        cache.saveUsers(remoteNews)
                    }
                    is DataEntity.ERROR -> {
                        send(remoteNews)
                    }
                }
            }
        }

        return producerChannel
    }
}