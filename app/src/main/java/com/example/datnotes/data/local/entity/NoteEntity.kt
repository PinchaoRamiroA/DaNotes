package com.example.datnotes.data.local.entity

import androidx.room.*

@Entity(
    tableName = "notes",
    foreignKeys = [
        ForeignKey(
            entity = FolderEntity::class,
            parentColumns = ["id"],
            childColumns = ["idCarpeta"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("idCarpeta")]
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "contenido") val contenido: String,
    @ColumnInfo(name = "fecha_creacion") val fechaCreacion: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "nivel_importancia") val nivelImportancia: Int = 1,
    @ColumnInfo(name = "tipo") val tipo: String, // texto, citas, recordatorio, apuntes, pasajeras
    @ColumnInfo(name = "estado") val estado: String = "activo", // activo, archivado
    @ColumnInfo(name = "idCarpeta") val idCarpeta: Int = 1
)
