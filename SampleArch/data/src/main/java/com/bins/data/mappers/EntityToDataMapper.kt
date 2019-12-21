package com.bins.data.mappers

import com.bins.data.entities.UserData
import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserEntity
import com.bins.domain.entity.UserResponseEntity

class EntityToDataMapper constructor() {

    fun mapUserToData(response: UserEntity): UserData = UserData(
        id = response.id,
        fname=response.fname,
        lname=response.lname,
        mediumPhoto= response.photoUrl,
        largePhoto =response.largePhoto,
        gender=response.gender,
        location=response.location,
        phone=response.phone,
        email=response.email,
        dob=response.dob
    )

    fun mapResponseToData(response: DataEntity<UserResponseEntity>): List<UserData>? {
        when (response) {
            is DataEntity.SUCCESS<UserResponseEntity> ->
                return@mapResponseToData response.data?.results?.map { mapUserToData(it) }
            is DataEntity.ERROR<UserResponseEntity> ->
                return@mapResponseToData response.data?.results?.map { mapUserToData(it) }
            is DataEntity.LOADING<UserResponseEntity> ->
                return@mapResponseToData response.data?.results?.map { mapUserToData(it) }
        }
    }

}