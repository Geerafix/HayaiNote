package com.hayainote.model.tag

import android.app.Application
import androidx.lifecycle.LiveData
import com.hayainote.room.HayaiNoteDatabase

class TagRepository(application: Application) {
    private var tagDao: TagDao?= null

    init {
        val database: HayaiNoteDatabase = HayaiNoteDatabase.getInstance(application)
        this.tagDao = database.tagDao()
    }

    fun getAllTags(): LiveData<List<Tag>>? {
        return tagDao?.findAllTags()
    }

    fun insertTag(tag: Tag) {
        HayaiNoteDatabase.executorService.execute {
            tagDao?.insertTag(tag)
        }
    }

    fun deleteTag(tag: Tag) {
        HayaiNoteDatabase.executorService.execute {
            tagDao?.deleteTag(tag)
        }
    }
}