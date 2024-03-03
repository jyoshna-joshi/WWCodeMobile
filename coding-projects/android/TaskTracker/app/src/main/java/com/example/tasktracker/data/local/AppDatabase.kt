package com.example.tasktracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Gauri Gadkari on 1/23/24.
 * The Room database for this app
 */

@Database(
    entities = [LocalTask::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
