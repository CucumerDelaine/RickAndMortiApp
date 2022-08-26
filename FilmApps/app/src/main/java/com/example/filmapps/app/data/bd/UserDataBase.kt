package com.example.filmapps.app.data.bd


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmapps.featureCharacterListAndDetails.data.model.Character
import com.example.filmapps.featureRegAndAuth.data.model.UserData
import com.example.filmapps.featureCharDetailsApi.data.bd.CharacterListDAO
import com.example.filmapps.featureAuthRegApi.data.bd.UserDataDAO

@Database(entities = [UserData::class, Character::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDataDao(): UserDataDAO
    abstract fun characterListDao(): CharacterListDAO
}
