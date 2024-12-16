package com.hayainote.model.note

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(application: Application) : ViewModel() {
    private var noteRepository: NoteRepository?= null

    init {
        noteRepository = NoteRepository(application)
    }

    fun getAllNotes(): LiveData<List<NoteWithTag>>? {
        return noteRepository?.getAllNotes()
    }

    fun insertNote(note: Note) {
        noteRepository?.insertNote(note)
    }
}