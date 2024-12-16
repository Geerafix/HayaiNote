package com.hayainote.model.note

import android.app.Application
import androidx.lifecycle.LiveData
import com.hayainote.room.HayaiNoteDatabase

class NoteRepository(application: Application) {
    private var noteDao: NoteDao?= null

    init {
        val database: HayaiNoteDatabase = HayaiNoteDatabase.getInstance(application)
        this.noteDao = database.noteDao()
    }

    fun getAllNotes(): LiveData<List<NoteWithTag>>? {
        return noteDao?.findAllNotes()
    }

    fun insertNote(note: Note) {
        HayaiNoteDatabase.executorService.execute {
            noteDao?.insertNote(note)
        }
    }
}