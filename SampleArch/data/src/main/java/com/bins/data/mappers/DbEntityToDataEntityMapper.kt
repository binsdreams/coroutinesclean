package com.bins.data.mappers

import com.bins.data.entities.UserData
import com.bins.domain.entity.UserEntity
import com.bins.domain.entity.UserResponseEntity

class DbEntityToDataEntityMapper constructor() {

    fun mapDbToDataEntity(response: UserData): UserEntity = UserEntity(
        id = response.id,
        fname=response.fname,
        lname=response.lname,
        photoUrl=response.mediumPhoto,
        largePhoto= response.largePhoto,
        gender=response.gender,
        location=response.location,
        phone=response.phone,
        email=response.email,
        dob=response.dob
    )


    fun mapDbToData(mapUserData: List<UserData>?) =
        UserResponseEntity(results = mapListUserResultToEntity(mapUserData))


    fun mapListUserResultToEntity(userData: List<UserData>?)
            : List<UserEntity> = userData?.map { mapDbToDataEntity(it) } ?: emptyList()
}