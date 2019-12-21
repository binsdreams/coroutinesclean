package com.bins.data.mappers

import com.bins.data.entities.Result
import com.bins.domain.entity.UserEntity
import com.bins.domain.entity.UserResponseEntity

class ResDataEntityMapper constructor() {

    fun mapToEntity(userResult: List<Result>?) =
        UserResponseEntity(results = mapListUserToEntity(userResult))

    fun mapListUserToEntity(articles: List<Result>?)
            : List<UserEntity> = articles?.map { mapArticleToEntity(it) } ?: emptyList()

    fun mapArticleToEntity(userRes: Result): UserEntity = UserEntity(
        fname = userRes.name?.first,
        lname = userRes.name?.last,
        photoUrl= userRes.picture?.medium,
        largePhoto = userRes.picture?.large,
        gender= userRes.gender,
        location= userRes.location?.city+","+userRes.location?.state+"'"+userRes.location?.country,
        phone= userRes.registered?.phone,
        email= userRes.email,
        dob= userRes.dob?.date
    )
}