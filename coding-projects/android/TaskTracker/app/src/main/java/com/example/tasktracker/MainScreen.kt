package com.example.tasktracker

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tasktracker.navigation.NavScreens
import com.example.tasktracker.ui.TaskDetail.TaskDetailScreen
import com.example.tasktracker.ui.TaskList.TaskListScreen
import com.example.tasktracker.ui.TaskSettings.TaskSettingsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreens.TaskList.route ) {
        composable(NavScreens.TaskList.route) {
            TaskListScreen(onNavigateToSettings = {navController.navigate(NavScreens.TaskSettings.route)})
        }
        composable(NavScreens.TaskSettings.route) {
            TaskSettingsScreen()
        }
        //TODO pass TASK_ID_ARG from list screen
        //val taskID = entry.arguments?.getString(TASK_ID_ARG)
        composable(NavScreens.TaskDetail.route) {
            entry ->
            TaskDetailScreen()
        }
    }
}