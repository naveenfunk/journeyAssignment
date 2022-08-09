package com.journeyassignment.ui.post_list

import androidx.lifecycle.ViewModel
import com.journeyassignment.data.State
import com.journeyassignment.data.mappers.mapError
import com.journeyassignment.data.mappers.toUiPosts
import com.journeyassignment.misc.log
import com.journeyassignment.use_cases.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(private val getPostListUseCase: GetPostListUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(PostListUiState(isLoading = true))
    val uiState : StateFlow<PostListUiState> = _uiState.asStateFlow()

    suspend fun getInitialPosts(){
        getPostListUseCase.getPosts().collect{ postsState ->
            when(postsState) {
                is State.Success -> {
                    log("update vm sucss")
                    _uiState.update { currentUiState ->
                        currentUiState.copy(postList = postsState.data.toUiPosts(), isLoading = false)
                    }
                }
                is State.Loading -> {
                    log("update vm loading")
                    _uiState.update {
                        it.copy(isLoading = true)
                    }
                }
                is State.Error -> {
                    log("update vm error")
                    _uiState.update {
                        it.copy(notifyMessageId = mapError(postsState.error), isLoading = false)
                    }
                }
            }
        }
    }
}