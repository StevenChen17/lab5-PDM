package com.example.lab5.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Long = Date().time,
    val isCompleted: Boolean = false
)