package com.hayainote.model.tag

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TagViewModel(application: Application) : ViewModel() {
    private var tagRepository: TagRepository?= null

    init {
        tagRepository = TagRepository(application)
    }

    fun getAllTags(): LiveData<List<Tag>>? {
        return tagRepository?.getAllTags()
    }

    fun insertTag(tag: Tag) {
        tagRepository?.insertTag(tag)
    }

    fun deleteTag(tag: Tag) {
        tagRepository?.deleteTag(tag)
    }
}