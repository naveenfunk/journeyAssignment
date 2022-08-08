package com.journeyassignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.journeyassignment.db.entities.Comment
import com.journeyassignment.db.entities.Post

@Dao
interface AppDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPosts(posts: List<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComments(comments: List<Comment>)

    @Query("SELECT * FROM post")
    suspend fun getPosts(): List<Post>

    @Query("SELECT * FROM comment")
    suspend fun getComments(): List<Comment>
}
