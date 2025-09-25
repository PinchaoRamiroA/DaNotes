package com.example.datnotes.core.di

import android.content.Context
import androidx.room.Room
import com.example.datnotes.data.local.AppDatabase
import com.example.datnotes.data.local.dao.FolderDao
import com.example.datnotes.data.local.dao.NoteDao
import com.example.datnotes.data.local.dao.TagDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "datnotes_db" // nombre del archivo de BD
        )
            .fallbackToDestructiveMigration(false) // borra la BD si cambias version (temporal en desarrollo)
        .build()
    }

    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao = db.noteDao()

    @Provides
    fun provideFolderDao(db: AppDatabase): FolderDao = db.folderDao()

    @Provides
    fun provideTagDao(db: AppDatabase): TagDao = db.tagDao()
}

