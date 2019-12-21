package com.bins.presentation.mapper

import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserEntity
import com.bins.domain.entity.UserResponseEntity
import com.bins.presentation.base.Mapper
import com.bins.presentation.entity.Data
import com.bins.presentation.entity.Error
import com.bins.presentation.entity.User
import com.bins.presentation.entity.UserResponse

class UserEntityMapper : Mapper<DataEntity<UserResponseEntity>, Data<UserResponse>>() {

    override fun mapFrom(data: DataEntity<UserResponseEntity>): Data<UserResponse> {
        when (data) {
            is DataEntity.SUCCESS -> return@mapFrom Data.SUCCESS(data.data?.let { mapSourcesToPresetation(it) })
            is DataEntity.ERROR -> return@mapFrom  Data.ERROR(error = Error( data.error.message))
            is DataEntity.LOADING -> return@mapFrom  Data.LOADING()
        }
    }

    private fun mapSourcesToPresetation(sources: UserResponseEntity)
            : UserResponse = UserResponse(count = sources?.count,page = sources?.page,
        results = mapListUsersToPresetation(sources?.results))


    private fun mapListUsersToPresetation(articles: List<UserEntity>?)
            : List<User> = articles?.map { mapArticleToPresentation(it) }
        ?: emptyList()

    private fun mapArticleToPresentation(response: UserEntity): User = User(
        id = response.id,
        fname = response.fname,
        lname = response.lname,
        dob = response.dob,
        email = response.email,
        location = response.location,
        gender = response.gender,
        phone = response.phone,
        mediumPhoto = response.photoUrl ?:"",
        largePhoto = response.largePhoto ?:""
    )

}