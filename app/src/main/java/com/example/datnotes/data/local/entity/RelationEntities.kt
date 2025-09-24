package com.example.datnotes.data.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class NoteWithTags(
    @Embedded val note: NoteEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = NoteTagCrossRef::class,
            parentColumn = "idNota",
            entityColumn = "idEtiqueta"
        )
    )
    val etiquetas: List<TagEntity>
)
