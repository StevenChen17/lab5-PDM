package com.example.lab5.data

import com.example.lab5.data.entities.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDAO) {

    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}