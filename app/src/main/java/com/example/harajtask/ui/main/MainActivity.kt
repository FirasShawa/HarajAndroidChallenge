package com.example.harajtask.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.example.harajtask.R
import com.example.harajtask.model.post.Post
import com.example.harajtask.model.post.PostAdapter
import com.example.harajtask.utils.Constants
import com.example.harajtask.utils.PostViewModel
import com.example.harajtask.viewmodel.post.PostViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var postAdapter: PostAdapter
    lateinit var viewModel : PostViewModel
    lateinit var mIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProviderFactory = PostViewModelProviderFactory(application)
        viewModel = ViewModelProvider(this,viewModelProviderFactory)
            .get(PostViewModel::class.java)

        postAdapter = PostAdapter()
        viewModel.getAllPosts().observe(this, Observer { list ->
            postAdapter.differ.submitList(list)
        })

        rv_posts.apply {
            adapter = postAdapter
        }


        postAdapter.SetOnClickListerner(object : PostAdapter.OnClickListerner {
            override fun onClick(position: Int, post: Post) {
                mIntent = Intent(applicationContext,PostDetails::class.java)
                mIntent.putExtra(Constants.SINGLE_POST_INTENT,post)
                startActivity(mIntent)
            }

        })

    }
}