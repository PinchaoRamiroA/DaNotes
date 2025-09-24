package com.example.datnotes.data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "note_tag_cross_ref",
    primaryKeys = ["idNota", "idEtiqueta"]
)
data class NoteTagCrossRef(
    val idNota: Int,
    val idEtiqueta: Int
)
