package com.example.datnotes.data.local.dao

import androidx.room.*
import com.example.datnotes.data.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE estado = 'ACTIVE' ")
    suspend fun getActiveNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE estado = 'ARCHIVED'")
    suspend fun getArchivedNotes(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity)

    @Update
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Query("UPDATE notes SET estado = 'ARCHIVED' WHERE id = :noteId")
    suspend fun archiveNote(noteId: Int)

    @Query("UPDATE notes SET estado = 'ACTIVE' WHERE id = :noteId")
    suspend fun restoreNote(noteId: Int)

    @Transaction
    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteWithTags(noteId: Int): NoteWithTags
}
