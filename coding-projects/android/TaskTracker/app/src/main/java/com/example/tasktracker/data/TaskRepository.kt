package com.example.tasktracker.data

import com.example.tasktracker.data.local.LocalTask
import com.example.tasktracker.data.local.TaskDao
import com.example.tasktracker.data.model.Task
import javax.inject.Inject

/**
 * Created by Gauri Gadkari on 1/23/24.
 */
class TaskRepository @Inject constructor(private val taskDao: TaskDao) : ITaskRepository{
    companion object{
        // these hardcoded strings should eventually be replaced by data based on user input
        val tasks = listOf(
            Task("Walking", "01:35:08", "Yesterday"),
            Task("finishing certifications", "03:40:04", "Yesterday"),
            Task("setting up new dryer unit", "01:20:21", "December 19, Tuesday"),
            Task("coding crunch time", "09:30:10", "December 19, Tuesday")
        )
    }
    override suspend fun updateTask(task: LocalTask){
        taskDao.updateTask(task)
    }

    override suspend fun insertTask(task: LocalTask){
        taskDao.insertTask(task)
    }


}