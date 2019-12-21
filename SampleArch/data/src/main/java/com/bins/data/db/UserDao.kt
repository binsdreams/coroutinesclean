package com.bins.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bins.data.entities.UserData
import io.reactivex.Flowable


@Dao
interface UserDao{

    @Query("Select * from userInformation")
    fun getUser() :Flowable<List<UserData>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsers(userDataList : List<UserData>)

    @Query("DELETE FROM userInformation")
    fun deleleAll()
}
