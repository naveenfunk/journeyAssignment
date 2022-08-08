package com.journeyassignment.ui.post_list

data class PostListUiState(
    val postList: List<PostUiState> = listOf(),
    val isLoading : Boolean = false,
    val notifyMessage : String = ""
)
