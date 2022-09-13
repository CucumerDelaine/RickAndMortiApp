package com.example.core_db_impl.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_db_impl.data.model.AppInfoEntity
import com.example.core_db_impl.data.model.CharacterEntity
import com.example.core_db_impl.data.model.UserData

@Database(entities = [UserData::class, CharacterEntity::class, AppInfoEntity::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDataDao(): UserDataDAO
    abstract fun characterListDao(): CharacterListDAO
    abstract fun appInfoDao(): AppInfoDAO
}
