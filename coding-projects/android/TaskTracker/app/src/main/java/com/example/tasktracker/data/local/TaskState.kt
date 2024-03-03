package com.example.tasktracker.data.local


/**
 * Created by Jyoshna Joshi on 2/17/24.
 * contains fields of task
 */
data class TaskState(
    val tasks: List<LocalTask> = emptyList(),
    val taskId: Int = 1,
    val taskTitle: String = "Walking",
    val taskDate: String = "February 12, Monday",
    val taskStartTime: String = "01:20:22",
    val taskEndTime: String = "01:50:22",
    val taskDuration: String = "02:30:22"
)