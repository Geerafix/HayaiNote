package com.hayainote.model.note

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun findAllNotes(): LiveData<List<NoteWithTag>>

    @Insert
    fun insertNote(note: Note)
}