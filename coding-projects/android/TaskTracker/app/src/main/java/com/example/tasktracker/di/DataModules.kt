package com.example.tasktracker.di

import android.content.Context
import androidx.room.Room
import com.example.tasktracker.data.ITaskRepository
import com.example.tasktracker.data.TaskRepository
import com.example.tasktracker.data.local.AppDatabase
import com.example.tasktracker.data.local.TaskDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModules {
    @Provides
    fun provideTaskDao(database: AppDatabase): TaskDao = database.taskDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "taskList.db"
        ).build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Singleton
    @Binds
    abstract fun bindTaskRepository(taskRepository: TaskRepository) : ITaskRepository
}