package com.journeyassignment.ui.post_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.journeyassignment.databinding.ItemPostBinding

class PostListAdapter(private val postClickListener : OnPostClickListener) : ListAdapter<PostUiState, PostListAdapter.PostListViewHolder>(PostUiState.PostListDiffUtil) {

    class PostListViewHolder(val binding : ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data : PostUiState){
            binding.post = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        return PostListViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        val post = getItem(position)
        holder.bindData(post)
        holder.binding.root.setOnClickListener{
            postClickListener.onPostClick(post)
        }
    }

    interface OnPostClickListener{
        fun onPostClick(post : PostUiState)
    }
}