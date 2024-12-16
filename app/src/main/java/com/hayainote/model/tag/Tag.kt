package com.hayainote.model.tag

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey(autoGenerate = true)
    val tid: Int = 0,

    @ColumnInfo(name = "name")
    var name: String,
) : Parcelable

