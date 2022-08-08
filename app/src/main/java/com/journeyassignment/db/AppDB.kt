package com.journeyassignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.journeyassignment.db.entities.Comment
import com.journeyassignment.db.entities.Post

@Database(
    version = 1,
    entities = [
        Post::class,
        Comment::class,
    ],
    exportSchema = false
)
abstract class AppDB : RoomDatabase() {

    abstract fun appDao(): AppDao
}