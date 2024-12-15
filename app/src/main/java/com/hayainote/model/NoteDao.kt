package com.hayainote.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun findAllNotes(): LiveData<List<Note>>

    @Insert
    fun insertNote(note: Note)
}