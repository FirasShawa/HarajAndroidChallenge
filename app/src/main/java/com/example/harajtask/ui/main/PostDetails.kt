package com.example.harajtask.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.model.post.Post
import com.example.harajtask.utils.Constants
import kotlinx.android.synthetic.main.activity_post_details.*

class PostDetails : AppCompatActivity(), View.OnClickListener {
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

        ib_post_details_share.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ib_post_details_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                val share_value = "Hey Check out this post on Haraj app:\n\n${post.title}\n\n${post.body}\n\n${post.username}"
                shareIntent.putExtra(Intent.EXTRA_TEXT, share_value)
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
        }
    }
}