package com.journeyassignment.ui.post_detail

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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.journeyassignment.databinding.FragmentPostDetailBinding
import com.journeyassignment.misc.log
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailFragment : Fragment() {

    private val postDetailViewModel by viewModels<PostDetailsViewModel>()
    private lateinit var binding: FragmentPostDetailBinding
    private val args: PostDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPostDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        observeData()
    }

    private fun observeData() {
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                postDetailViewModel.uiState.collect{ postDetailsUiState ->
                    log("update ui state")
                    updateUiList(postDetailsUiState.commentList)
                    binding.progress.isVisible = postDetailsUiState.isLoading
                    postDetailsUiState.notifyMessageId?.let {
                        Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun updateUiList(commentList: List<CommentUiState>) {
        if (binding.commentsList.adapter == null){
            CommentListAdapter().apply {
                this.submitList(commentList)
            }.also { binding.commentsList.adapter = it }
            binding.commentsList.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }else{
            (binding.commentsList.adapter as CommentListAdapter).submitList(commentList)
        }
    }

    private fun initData() {
        (requireActivity() as AppCompatActivity).title = args.postTitle
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                postDetailViewModel.getInitialComments(args.postId)
            }
        }
    }

}