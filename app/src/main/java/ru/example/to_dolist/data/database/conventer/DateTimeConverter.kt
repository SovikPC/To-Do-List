package ru.example.to_dolist.data.database.conventer

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class DateTimeConverter {
    @TypeConverter
    fun fromTimeStamp(value: Long): LocalDateTime {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneOffset.UTC)
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime): Long {
        return date.atZone(ZoneOffset.UTC).toInstant().toEpochMilli()
    }

}