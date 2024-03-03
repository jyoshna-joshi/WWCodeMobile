package com.example.tasktracker.data

import com.example.tasktracker.data.local.LocalTask

/**
 * Created by Jyoshna on 2/25/24
 */
interface ITaskRepository {
    suspend fun updateTask(task: LocalTask)
    suspend fun insertTask(task: LocalTask)
}