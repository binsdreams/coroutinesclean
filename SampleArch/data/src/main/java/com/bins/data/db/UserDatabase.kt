package com.bins.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bins.data.entities.UserData

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract fun getUserDao() : UserDao
}