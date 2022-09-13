package com.example.core_db_impl.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_db_impl.data.model.AppInfoEntity

@Dao
interface AppInfoDAO {
    @Query("SELECT * FROM AppInfoEntity WHERE id = :id")
    fun getById(id: Int): AppInfoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(appInfoEntity: AppInfoEntity)
}