package com.bobo.memohae.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "folder")
    var folder: String = "",

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "is_deleted")
    var isDeleted: Boolean = false
)