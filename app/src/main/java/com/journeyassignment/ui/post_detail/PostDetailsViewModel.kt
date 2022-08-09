package com.journeyassignment.ui.post_detail

import androidx.lifecycle.ViewModel
import com.journeyassignment.data.State
import com.journeyassignment.data.mappers.mapError
import com.journeyassignment.data.mappers.toUiComments
import com.journeyassignment.use_cases.GetCommentListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(private val getCommentListUseCase: GetCommentListUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(PostDetailsUiState(isLoading = true))
    val uiState : StateFlow<PostDetailsUiState> = _uiState.asStateFlow()

    suspend fun getInitialComments(postId : Long){
        getCommentListUseCase.getComments(postId).collect{ commentsState ->
            when(commentsState) {
                is State.Success -> {
                    _uiState.update { currentUiState ->
                        currentUiState.copy(commentList = commentsState.data.toUiComments(), isLoading = false)
                    }
                }
                is State.Loading -> {
                    _uiState.update {
                        it.copy(isLoading = true)
                    }
                }
                is State.Error -> {
                    _uiState.update {
                        it.copy(notifyMessageId = mapError(commentsState.error), isLoading = false)
                    }
                }
            }
        }
    }
}