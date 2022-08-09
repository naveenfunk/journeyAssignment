package com.journeyassignment.ui.post_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.journeyassignment.databinding.ItemCommentBinding

class CommentListAdapter : ListAdapter<CommentUiState, CommentListAdapter.CommentListViewHolder>(CommentUiState.CommentListDiffUtil) {

    class CommentListViewHolder(private val binding : ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data : CommentUiState){
            binding.setComment(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentListViewHolder {
        return CommentListViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CommentListViewHolder, position: Int) {
        val post = getItem(position)
        holder.bindData(post)
    }
}