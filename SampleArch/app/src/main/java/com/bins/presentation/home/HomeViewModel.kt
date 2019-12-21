package com.bins.presentation.home

import androidx.lifecycle.MutableLiveData
import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import com.bins.domain.usecases.UserInfoUseCase
import com.bins.presentation.base.BaseViewModel
import com.bins.presentation.base.Mapper
import com.bins.presentation.entity.Data
import com.bins.presentation.entity.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel (private val getUserInfoUseCase: UserInfoUseCase,
                     private val mapper: Mapper<DataEntity<UserResponseEntity>, Data<UserResponse>>) : BaseViewModel() {

    var users = MutableLiveData<Data<UserResponse>>()

    fun fetchUsers() {
        launch {
            val usersResponse = getUserInfoUseCase.getUserData()
            usersResponse.consumeEach { response ->
                val mappedResponse = mapper.mapFrom(response)
                //Switching the context to main
                withContext(Dispatchers.Main) {
                    users.postValue(mappedResponse)
                }
            }
        }
    }

    fun getUserLiveData() = users
}