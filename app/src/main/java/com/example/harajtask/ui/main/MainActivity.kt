package com.example.harajtask.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.harajtask.R
import com.example.harajtask.model.post.PostAdapter
import com.example.harajtask.utils.PostViewModel
import com.example.harajtask.viewmodel.post.PostViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var postAdapter: PostAdapter
    lateinit var viewModel : PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProviderFactory = PostViewModelProviderFactory(application)
        viewModel = ViewModelProvider(this,viewModelProviderFactory)
            .get(PostViewModel::class.java)

        postAdapter = PostAdapter(viewModel.getAllPosts())

        rv_posts.apply {
            adapter = postAdapter
        }

    }
}