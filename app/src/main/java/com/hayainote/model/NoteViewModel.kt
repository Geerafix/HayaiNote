package com.hayainote.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(application: Application) : ViewModel() {
    private var noteRepository: NoteRepository?= null

    init {
        noteRepository = NoteRepository(application)
    }

    fun getAllNotes(): LiveData<List<Note>>? {
        return noteRepository?.getAllNotes()
    }

    fun insertNote(note: Note) {
        noteRepository?.insertNote(note)
    }
}