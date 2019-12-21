package com.bins.presentation.userdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bins.presentation.entity.User

/**
 * sample class which we can extent to talk get from db.
 * just to show case simple way of usage viewmodel
 */
class UserDetailViewModel () : ViewModel() {

    var selectedUser = MutableLiveData<User>()

    fun getUser(user: User) {
        selectedUser = MutableLiveData(user)
    }

    fun getUserLiveData() = selectedUser


}