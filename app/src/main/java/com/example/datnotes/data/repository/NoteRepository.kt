package com.example.datnotes.data.repository

import com.example.datnotes.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    // CRUD Básico
    suspend fun insertNote(note: NoteEntity): Long
    suspend fun getNoteById(id: Long): NoteEntity?
    suspend fun getAllNotes(): Flow<List<NoteEntity>>
    suspend fun updateNote(note: NoteEntity)
    suspend fun deleteNote(note: NoteEntity)

    // Funciones específicas del requerimiento
    suspend fun getArchivedNotes(): Flow<List<NoteEntity>>
    suspend fun getNotesByFolder(folderId: Long): Flow<List<NoteEntity>>
    suspend fun getNotesByTag(tag: String): Flow<List<NoteEntity>>

    // Operaciones de estado/movimiento
    suspend fun archiveNote(noteId: Long)
    suspend fun moveNoteToFolder(noteId: Long, folderId: Long)
}