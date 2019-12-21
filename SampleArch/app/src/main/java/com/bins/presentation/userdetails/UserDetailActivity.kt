package com.bins.presentation.userdetails

import android.content.Context
import android.content.Intent
import android.content.Intent.EXTRA_USER
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bins.R
import com.bins.databinding.UserDetailActivityBinding
import com.bins.presentation.common.loadImage
import com.bins.presentation.entity.User
import kotlinx.android.synthetic.main.user_detail_activity.*
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * this class is sample to show how we can set values to view, without data binding in MVVM(View model).
 */
class UserDetailActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context?, user: User?) : Intent?{
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra(EXTRA_USER, user)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            return intent
        }
    }

    private val userDetailViewModel: UserDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: UserDetailActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.user_detail_activity)
        val intent = getIntent()
        val user = intent.getParcelableExtra(EXTRA_USER) as User

        userDetailViewModel.getUser(user)

        binding.userDetailViewModel = userDetailViewModel
        userDetailViewModel.selectedUser.observe(this, Observer {
            userImageLarge.loadImage(it.largePhoto)
        })

    }
}
