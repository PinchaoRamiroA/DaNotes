package com.example.datnotes.domain.repository

import com.example.datnotes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun getActiveNotes(): Flow<List<Note>>
    suspend fun getArchivedNotes(): Flow<List<Note>>
    suspend fun insertNote(note: Note): Long
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun archiveNote(id: Long)
    suspend fun restoreNote(id: Long)
}
