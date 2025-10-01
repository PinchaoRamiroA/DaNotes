package com.example.datnotes.data.mapper

import com.example.datnotes.data.local.entity.NoteEntity
import com.example.datnotes.domain.model.Note
import com.example.datnotes.domain.model.NoteState
import com.example.datnotes.domain.model.NoteType
import java.util.*

fun NoteEntity.toDomain(): Note {
    return Note(
        id = id,
        title = name,
        content = content,
        createdAt = Date(createdAt),
        importance = importance,
        type = NoteType.valueOf(type),
        state = if (state == "ARCHIVED") NoteState.ARCHIVED else NoteState.ACTIVE,
        folderId = folderId
    )
}

fun Note.toEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        name = title,
        content = content,
        createdAt = createdAt.time,
        importance = importance,
        type = type.name,
        state = if (state == NoteState.ARCHIVED) "ARCHIVED" else "ACTIVE",
        folderId = folderId
    )
}
