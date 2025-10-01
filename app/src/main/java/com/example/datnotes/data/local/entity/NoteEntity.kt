package com.example.datnotes.data.local.entity

import androidx.room.*
import com.example.datnotes.constants.NoteType
import com.example.datnotes.constants.NoteState

@Entity(
    tableName = "notes",
    foreignKeys = [
        ForeignKey(
            entity = FolderEntity::class,
            parentColumns = ["id"],
            childColumns = ["folderId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("folderId"), Index("estado")]
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre") val name: String,
    @ColumnInfo(name = "contenido") val content: String,
    @ColumnInfo(name = "fecha_creacion") val createdAt: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "nivel_importancia") val importance: Int = 1,
    @ColumnInfo(name = "tipo") val type: NoteType = NoteType.TEXTO, // texto, citas, recordatorio, apuntes, pasajeras
    @ColumnInfo(name = "estado") val state: NoteState = NoteState.ACTIVE, // active, archived
    @ColumnInfo(name = "id_carpeta") val folderId: Int? = null
)
