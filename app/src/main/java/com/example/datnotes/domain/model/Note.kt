package com.example.datnotes.domain.model

import java.util.*

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Date = Date(),
    val importance: Int = 1, // 1..5
    val type: NoteType = NoteType.TEXT,
    val state: NoteState = NoteState.ACTIVE,
    val folderId: Int? = null
)

enum class NoteType { TEXT, QUOTE, REMINDER, NOTES, TRANSIENT }
enum class NoteState { ACTIVE, ARCHIVED }
