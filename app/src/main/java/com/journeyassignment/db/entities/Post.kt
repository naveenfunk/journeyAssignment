package com.journeyassignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.journeyassignment.misc.TABLE_POST

@Entity(tableName = TABLE_POST)
data class Post(
    @PrimaryKey
    val id : Long,
    val title : String?,
    val description : String?
)
