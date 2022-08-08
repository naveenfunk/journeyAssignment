package com.journeyassignment.ui.post_list

import androidx.lifecycle.ViewModel
import com.journeyassignment.use_cases.GetPostListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class PostListViewModel @Inject constructor(private val getPostListUseCase: GetPostListUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(PostListUiState())
    val uiState : StateFlow<PostListUiState> = _uiState.asStateFlow()

    suspend fun getInitialPosts(){
        getPostListUseCase.getPosts().collect{
        }
    }
}