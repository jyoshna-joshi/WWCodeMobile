package com.example.tasktracker.ui.TaskDetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasktracker.data.TaskRepository
import com.example.tasktracker.data.local.LocalTask
import com.example.tasktracker.data.local.TaskState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Gauri Gadkari on 1/23/24.
 * Edit logic developed by Jyoshna 2/20/24
 */
@HiltViewModel
class TaskDetailViewModel @Inject constructor(
    private var repository: TaskRepository, savedStateHandle: SavedStateHandle
) : ViewModel() {
    //    private val taskId: String? = savedStateHandle[TaskArgs.TASK_ID_ARG]
    private val taskId = 1 // TODO remove this static value once taskId is obtained from list
    private val _state = MutableStateFlow(TaskState())
    val state: StateFlow<TaskState> = _state.asStateFlow()

    //when done button is clicked from ui
    fun saveTask() {
        if (state.value.taskTitle.isEmpty() || state.value.taskStartTime.isEmpty() || state.value.taskEndTime.isEmpty() || state.value.taskDate.isEmpty()) {
            return
        }
        if (taskId == null) {
          //  createNewTask()
        } else {
            updateTask()
        }
    }

    /**
     * creates new task
     */
     fun createNewTask() {
        //todo change values for add logic and remove these static value
        viewModelScope.launch {
            val taskId = 1
            val taskTitle = "abcd"
            val taskStartTime = "1:2"
            val taskEndTime = "2:1"
            val taskDate = "2/2/24"
            val task = LocalTask(
                taskId = taskId,
                taskTitle = taskTitle,
                taskDate = taskDate,
                taskStartTime = taskStartTime,
                taskEndTime = taskEndTime,
            )
            repository.insertTask(task = task)
        }
    }

    /**
     * update existing task
     */
    private fun updateTask() {
        if (taskId == null) {
            throw RuntimeException("updateTask() called in new task")
        }
        viewModelScope.launch {
            val taskId = state.value.taskId
            val taskTitle = state.value.taskTitle
            val taskStartTime = state.value.taskStartTime
            val taskEndTime = state.value.taskEndTime
            val taskDate = state.value.taskDate
            val task = LocalTask(
                taskId = taskId,
                taskTitle = taskTitle,
                taskDate = taskDate,
                taskStartTime = taskStartTime,
                taskEndTime = taskEndTime,
            )
            repository.updateTask(task = task)
        }
    }

    /**
     * updates date with new selected date
     */
    fun updateDate(newDate: String) {
        _state.update {
            it.copy(
                taskDate = newDate
            )
        }
    }

    /**
     * updates end time with new selected end time
     */
    fun updateEndTime(newEndTime: String) {
        _state.update {
            it.copy(
                taskEndTime = newEndTime
            )
        }
    }

    /**
     * updates start time with new selected start time
     */
    fun updateStartTime(newStartTime: String) {
        _state.update {
            it.copy(
                taskStartTime = newStartTime
            )
        }
    }

    /**
     * updates task with new task
     */
    fun updateTaskName(newTaskName: String) {

        _state.update {
            it.copy(
                taskTitle = newTaskName
            )
        }
    }

    //todo calculate duration
    /**
     * update new duration
     */
    fun updateDuration(newDuration: String) {
        _state.update {
            it.copy(
//                      taskDuration = event.taskEndTime - event.taskStartTime
            )
        }
    }
}