package com.hayainote.model.note

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.hayainote.model.tag.Tag
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity(tableName = "notes")
@Parcelize
data class Note (
    @PrimaryKey(autoGenerate = true)
    val nid: Int = 0,

    @ColumnInfo(name = "tid")
    var tid: Int?= null,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "date")
    val date: String = Date().toString()
) : Parcelable

@Parcelize
data class NoteWithTag (
    @Embedded
    var note: Note,

    @Relation(
        parentColumn = "tid",
        entityColumn = "tid"
    )
    var tag: Tag?
) : Parcelable
