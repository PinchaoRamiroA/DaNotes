package com.example.datnotes.data.local.dao

import androidx.room.*
import com.example.datnotes.data.local.entity.TagEntity
import com.example.datnotes.data.local.entity.NoteTagCrossRef

@Dao
interface TagDao {
    @Query("SELECT * FROM tags")
    suspend fun getAllTags(): List<TagEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tag: TagEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossRef(crossRef: NoteTagCrossRef)

    @Delete
    suspend fun delete(tag: TagEntity)
}
