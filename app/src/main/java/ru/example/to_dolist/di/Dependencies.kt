package ru.example.to_dolist.di

import android.content.Context
import androidx.room.Room
import ru.example.to_dolist.data.database.AppDatabase

object Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context){
        applicationContext=context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(
            context = applicationContext,
            klass = AppDatabase::class.java,
            name = "database.db"
        )
            .createFromAsset("room_article.db")
            .build()
    }

}