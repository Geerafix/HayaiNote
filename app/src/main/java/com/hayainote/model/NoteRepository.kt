package com.hayainote.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.hayainote.room.NoteDatabase

class NoteRepository(application: Application) {
    private var noteDao: NoteDao?= null

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(application)
        this.noteDao = database.noteDao()
    }

    fun getAllNotes(): LiveData<List<Note>>? {
        return noteDao?.findAllNotes()
    }

    fun insertNote(note: Note) {
        NoteDatabase.executorService.execute {
            noteDao?.insertNote(note)
        }
    }
}