package ru.example.to_dolist.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.example.to_dolist.data.database.dao.TaskDao
import ru.example.to_dolist.data.mapper.TaskMapper
import ru.example.to_dolist.domain.model.TaskDomain

class TaskRepository(
    private val dao: TaskDao,
    private val mapper: TaskMapper
){

    fun getAllTask(): Flow<List<TaskDomain>> {
        return dao.selectAllTask().map { list ->
            mapper.toListDomain(list)
        }
    }

    fun getByIdTask(id: Long): Flow<TaskDomain> {
        return dao.selectByIdTask(id).map { entity ->
            mapper.toDomain(entity)
        }
    }

    suspend fun addTask(domain: TaskDomain) {
        withContext(Dispatchers.IO){
            dao.insertTask(domain.toEntity())
        }
    }

    suspend fun updateTask(domain: TaskDomain) {
        withContext(Dispatchers.IO){
            dao.updateTask(domain.toEntity())
        }
    }

    suspend fun deleteTask(id: Long) {
        withContext(Dispatchers.IO){
            dao.delete(id)
        }
    }
}