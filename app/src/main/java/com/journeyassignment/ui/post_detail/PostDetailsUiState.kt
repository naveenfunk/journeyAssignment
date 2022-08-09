package com.journeyassignment.ui.post_detail

data class PostDetailsUiState(
    val commentList: List<CommentUiState> = listOf(),
    val title : String = "",
    val isLoading : Boolean = false,
    val notifyMessageId : Int? = null
)
