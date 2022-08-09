package com.journeyassignment.ui.post_detail

import androidx.recyclerview.widget.DiffUtil

data class CommentUiState(
    val id : Long = -1,
    val name : String = "",
    val email : String = "",
    val description : String = ""
){
    object CommentListDiffUtil : DiffUtil.ItemCallback<CommentUiState>() {
        override fun areItemsTheSame(oldItem: CommentUiState, newItem: CommentUiState): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CommentUiState, newItem: CommentUiState): Boolean {
            return oldItem == newItem
        }
    }
}