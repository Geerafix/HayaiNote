package com.hayainote.model.tag

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete
import androidx.room.Insert;
import androidx.room.Query;

@Dao
interface TagDao {
    @Query("SELECT * FROM tags")
    fun findAllTags(): LiveData<List<Tag>>

    @Insert
    fun insertTag(tag: Tag)

    @Delete
    fun deleteTag(tag: Tag)
}
