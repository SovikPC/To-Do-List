package ru.example.to_dolist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.example.to_dolist.data.database.conventer.DateTimeConverter
import ru.example.to_dolist.data.database.dao.TaskDao
import ru.example.to_dolist.data.database.entity.TaskEntity

@Database(
    version = 3,
    exportSchema = true,
    entities = [
        TaskEntity::class
    ]
)
@TypeConverters(DateTimeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}