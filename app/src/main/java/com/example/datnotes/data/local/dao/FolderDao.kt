package com.example.datnotes.data.local.dao

import androidx.room.*
import com.example.datnotes.data.local.entity.FolderEntity

@Dao
interface FolderDao {
    @Query("SELECT * FROM folders")
    suspend fun getAllFolders(): List<FolderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(folder: FolderEntity)

    @Delete
    suspend fun delete(folder: FolderEntity)
}
