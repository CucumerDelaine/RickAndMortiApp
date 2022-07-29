package com.example.filmapps.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData (
    @ColumnInfo
    var login: String,
    @ColumnInfo
    var pass: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
