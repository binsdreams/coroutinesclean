package com.bins.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bins.R
import com.bins.presentation.entity.Data
import com.bins.presentation.entity.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var listAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        listAdapter = UserListAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view.adapter = listAdapter
        val decoration =
            DividerItemDecoration(applicationContext, LinearLayout.VERTICAL)
        recycler_view.addItemDecoration(decoration)
        progress_circular.visibility = View.VISIBLE;
        homeViewModel.fetchUsers()
    }

    override fun onStart() {
        super.onStart()

        homeViewModel.getUserLiveData().observe(this, Observer {
            when (it) {
                is Data.ERROR -> {
                    //Error handling
                    var error = it.error?.message as CharSequence;
                    Snackbar.make(recycler_view,error,Snackbar.LENGTH_LONG).show()
                    progress_circular.visibility = View.INVISIBLE;
                }
                is Data.LOADING -> {
                    //Progress
                    progress_circular.visibility = View.VISIBLE;
                }
                is Data.SUCCESS -> {
                    progress_circular.visibility = View.GONE;
                    it.data?.let { userResponse -> listAdapter.updateList(userResponse.results) }
                }
            }
        })
    }


}
