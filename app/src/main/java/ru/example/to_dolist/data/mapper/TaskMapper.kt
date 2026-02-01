package ru.example.to_dolist.data.mapper

import ru.example.to_dolist.data.database.entity.TaskEntity
import ru.example.to_dolist.domain.model.TaskDomain

class TaskMapper {

    fun toEntity(domain: TaskDomain): TaskEntity = TaskEntity(
        id = domain.id,
        title = domain.title,
        description = domain.description,
        isCompleted = domain.isCompleted,
        createdAt = domain.createdAt,
        updatedAt = domain.updatedAt
    )

    fun toDomain(entity: TaskEntity): TaskDomain = TaskDomain(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        isCompleted = entity.isCompleted,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )

    fun toListDomain(listEntity: List<TaskEntity>): List<TaskDomain> {
        return listEntity.map { entity ->
            toDomain(entity)
        }
    }

}