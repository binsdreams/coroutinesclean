package com.bins.data.repository

import com.bins.data.db.UserDao
import com.bins.data.db.UserDatabase
import com.bins.data.mappers.DbEntityToDataEntityMapper
import com.bins.data.mappers.EntityToDataMapper
import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription

class UserCacheImpl(private val database: UserDatabase,
                    private val entityToDataMapper: EntityToDataMapper,
                    private val dbToDataMapper: DbEntityToDataEntityMapper) : UserDataStore {

    private val dao: UserDao = database.getUserDao()

    override suspend fun getRandomUsers(): ReceiveChannel<DataEntity<UserResponseEntity>> {
        val mappedValue = dao.getUser().map { it ->
            DataEntity.SUCCESS(dbToDataMapper.mapDbToData(it))
        }
        return mappedValue.openSubscription()
    }

    fun saveUsers(response: DataEntity<UserResponseEntity>) {
        entityToDataMapper.mapResponseToData(response)?.let {
            dao.deleleAll()
            dao.saveUsers(it)
        }
    }

}