package com.example.tasktracker.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Jyoshna Joshi on 2/17/24.
 */
@Entity(
    tableName = "task"
)
data class LocalTask(
    @PrimaryKey(autoGenerate = true) val taskId: Int = 0,
    @ColumnInfo(name = "taskTitle") val taskTitle: String,
    @ColumnInfo(name = "taskDate") val taskDate: String,
    @ColumnInfo(name = "taskStartTime") val taskStartTime: String,
    @ColumnInfo(name = "taskEndTime") val taskEndTime: String
)
