package com.example.tasktracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

/**
 * Created by Gauri Gadkari on 1/23/24.
 */
@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: LocalTask)
    @Update
    suspend fun updateTask(task: LocalTask)
}