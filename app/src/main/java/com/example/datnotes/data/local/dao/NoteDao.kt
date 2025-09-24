package com.example.datnotes.data.local.dao

import androidx.room.*
import com.example.datnotes.data.local.entity.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE estado = 'activo'")
    suspend fun getActiveNotes(): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE estado = 'archivado'")
    suspend fun getArchivedNotes(): List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity)

    @Update
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Transaction
    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteWithTags(noteId: Int): NoteWithTags
}
