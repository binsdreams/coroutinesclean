package com.bins.presentation.home

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import com.bins.presentation.entity.User
import com.bins.presentation.userdetails.UserDetailActivity


class UserIViewModel constructor(private var context: Context? ,private var user: User) : BaseObservable() {

    fun getName(): String? {
        return user.fname +" "+user.lname
    }

    fun getPhoto(): String? {
        return user.mediumPhoto
    }

    fun getGender(): String? {
        return user.gender;
    }

    fun onClickUser(): View.OnClickListener? {
        return View.OnClickListener { launchUserDetailsActivity() }
    }

    private fun launchUserDetailsActivity() {
        context?.startActivity(UserDetailActivity.getStartIntent(context, user));
    }
}