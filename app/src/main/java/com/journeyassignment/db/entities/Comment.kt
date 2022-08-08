package com.journeyassignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.journeyassignment.misc.TABLE_COMMENT

@Entity(tableName = TABLE_COMMENT)
data class Comment(
    @PrimaryKey
    val id : Long,
    val postId : Long,
    val title : String?,
    val description : String?
)
