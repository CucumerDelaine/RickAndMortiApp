package com.example.filmapps.data.bd


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmapps.feature.regAndAuth.data.model.UserData

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDataDao(): UserDataDAO
}