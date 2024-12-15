package com.hayainote.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity(tableName = "notes")
@Parcelize
data class Note (
    @PrimaryKey(autoGenerate = true)
    val nid: Int = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "tag")
    var tag: String = "",

    @ColumnInfo(name = "date")
    val date: String = Date().toString()
) : Parcelable
