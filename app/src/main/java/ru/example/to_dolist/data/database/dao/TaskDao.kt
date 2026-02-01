package ru.example.to_dolist.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.example.to_dolist.data.database.entity.TaskEntity

@Dao
interface TaskDao {
    @Query("Select * from TaskEntity")
    fun selectAllTask(): Flow<List<TaskEntity>>
    @Query("Select * from TaskEntity where id = :id")
    fun selectByIdTask(id: Long): Flow<TaskEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(taskEntity: TaskEntity)
    @Delete
    suspend fun delete(id: Long)
}