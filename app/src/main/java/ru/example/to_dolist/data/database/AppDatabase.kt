package ru.example.to_dolist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.example.to_dolist.data.database.dao.TaskDao
import ru.example.to_dolist.data.database.entity.TaskEntity

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        TaskEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}