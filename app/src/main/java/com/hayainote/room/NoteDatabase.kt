package com.hayainote.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hayainote.model.Note
import com.hayainote.model.NoteDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao?

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        fun getInstance(context: Context): NoteDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "notes.db"
                    )
                        .build()
                }

                return instance;
            }
        }
    }
}