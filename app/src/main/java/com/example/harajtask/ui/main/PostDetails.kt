package com.example.harajtask.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.model.post.Post
import com.example.harajtask.utils.Constants
import kotlinx.android.synthetic.main.activity_post_details.*

class PostDetails : AppCompatActivity() {
    lateinit var post:Post
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)

        if(intent.hasExtra(Constants.SINGLE_POST_INTENT)){
            post = intent.getParcelableExtra<Post>(Constants.SINGLE_POST_INTENT)!!
        }

        Glide.with(this).load(post.thumbURL).into(img_post_details_thumb)
        tv_post_details_title.text = post.title
        tv_post_details_city.text = post.city
        tv_post_details_date.text = Constants.ConvertTimeStampToDate(post.date)
        tv_post_details_username.text = post.username
        tv_post_details_body.text = post.body
    }
}