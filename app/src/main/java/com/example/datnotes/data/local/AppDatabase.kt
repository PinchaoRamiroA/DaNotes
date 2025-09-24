package com.example.datnotes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datnotes.data.local.dao.*
import com.example.datnotes.data.local.entity.*

@Database(
    entities = [
        NoteEntity::class,
        FolderEntity::class,
        TagEntity::class,
        NoteTagCrossRef::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao
    abstract fun tagDao(): TagDao
}
