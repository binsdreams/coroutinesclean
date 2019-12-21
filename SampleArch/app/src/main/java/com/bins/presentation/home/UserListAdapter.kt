package com.bins.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bins.R
import com.bins.databinding.UserItemBinding
import com.bins.presentation.common.loadImage
import com.bins.presentation.entity.User
import kotlinx.android.synthetic.main.user_item.view.*


class UserListAdapter : RecyclerView.Adapter<UserListAdapter.NewsViewHolder>() {

    var userlist = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val userItemBinding: UserItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.user_item,
            parent, false
        )
        return NewsViewHolder(userItemBinding)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(userlist[position])
    }

    class NewsViewHolder(private var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.userViewModel = UserIViewModel(binding.root.context,user)
            //For some reason not able to work app:profileImage}" properties
            binding.userImage.loadImage(binding.userViewModel?.getPhoto()?:"")
        }
    }

    fun updateList(list: List<User>) {
        if (list.isNotEmpty()) {
            userlist.clear()
            userlist.addAll(list)
            notifyDataSetChanged()
        }
    }
}