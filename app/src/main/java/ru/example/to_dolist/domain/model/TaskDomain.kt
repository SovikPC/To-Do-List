package ru.example.to_dolist.domain.model

import ru.example.to_dolist.data.database.entity.TaskEntity

data class TaskDomain(
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
){
    fun toEntity(): TaskEntity = TaskEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
