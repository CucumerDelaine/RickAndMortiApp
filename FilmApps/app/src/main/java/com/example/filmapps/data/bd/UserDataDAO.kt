package com.example.filmapps.data.bd


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.filmapps.feature.regAndAuth.data.model.UserData

@Dao
interface UserDataDAO {
    @Query("SELECT * FROM UserData WHERE login = :login and pass = :pass")
    fun getUserData(login: String, pass: String) : UserData?

    @Insert
    fun insert(userData: UserData)
}