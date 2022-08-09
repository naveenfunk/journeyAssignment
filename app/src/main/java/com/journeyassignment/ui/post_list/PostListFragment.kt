package com.journeyassignment.ui.post_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.journeyassignment.R
import com.journeyassignment.databinding.FragmentPostListBinding
import com.journeyassignment.misc.log
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostListFragment : Fragment(), PostListAdapter.OnPostClickListener {

    private val postListViewModel by viewModels<PostListViewModel>()
    private lateinit var binding: FragmentPostListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPostListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        observeData()
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                postListViewModel.uiState.collect { postListUiState ->
                    log("update ui state")
                    updateUiList(postListUiState.postList)
                    binding.progress.isVisible = postListUiState.isLoading
                    postListUiState.notifyMessageId?.let {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun updateUiList(postList: List<PostUiState>) {
        if (binding.postList.adapter == null) {
            PostListAdapter(this@PostListFragment).apply {
                this.submitList(postList)
            }.also { binding.postList.adapter = it }
            binding.postList.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    RecyclerView.VERTICAL
                )
            )
        } else {
            (binding.postList.adapter as PostListAdapter).submitList(postList)
        }
    }

    private fun initData() {
        (requireActivity() as AppCompatActivity).title = getString(R.string.posts)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                postListViewModel.getInitialPosts()
            }
        }
    }

    override fun onPostClick(post: PostUiState) {
        val directions = PostListFragmentDirections.actionPostListFragmentToPostDetailFragment()
        directions.postId = post.id
        directions.postTitle = post.title
        binding.root.findNavController().navigate(directions)
    }
}