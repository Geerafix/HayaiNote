package com.hayainote.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hayainote.model.note.Note
import com.hayainote.model.note.NoteDao
import com.hayainote.model.tag.Tag
import com.hayainote.model.tag.TagDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Note::class, Tag::class], version = 1, exportSchema = false)
abstract class HayaiNoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao?
    abstract fun tagDao(): TagDao?

    companion object {
        @Volatile
        private var INSTANCE: HayaiNoteDatabase? = null

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        fun getInstance(context: Context): HayaiNoteDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HayaiNoteDatabase::class.java,
                        "notes.db"
                    )
                        .build()
                }

                return instance;
            }
        }
    }
}