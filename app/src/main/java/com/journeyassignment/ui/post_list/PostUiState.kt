package com.journeyassignment.ui.post_list

import androidx.recyclerview.widget.DiffUtil

data class PostUiState(
    val id : Long = -1,
    val title : String = "",
    val description : String = ""
){
    object PostListDiffUtil : DiffUtil.ItemCallback<PostUiState>() {
        override fun areItemsTheSame(oldItem: PostUiState, newItem: PostUiState): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostUiState, newItem: PostUiState): Boolean {
            return oldItem == newItem
        }
    }
}