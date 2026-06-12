package com.example.lab5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab5.data.entities.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "task_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}