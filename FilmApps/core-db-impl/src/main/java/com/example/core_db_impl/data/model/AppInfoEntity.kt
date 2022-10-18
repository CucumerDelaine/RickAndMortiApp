package com.example.core_db_impl.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AppInfoEntity(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val time: Long,
    @ColumnInfo
    var page: Int
)