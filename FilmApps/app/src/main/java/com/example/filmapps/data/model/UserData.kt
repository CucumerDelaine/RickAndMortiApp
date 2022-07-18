package com.example.filmapps.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserData {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    @ColumnInfo
    var login: String = ""

    @ColumnInfo
    var pass: String = ""
}
