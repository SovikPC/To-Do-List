package ru.example.to_dolist.domain.model

import ru.example.to_dolist.data.database.entity.TaskEntity
import java.time.LocalDateTime

data class TaskDomain(
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
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
