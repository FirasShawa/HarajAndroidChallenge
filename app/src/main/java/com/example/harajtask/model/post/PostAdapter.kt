package com.example.harajtask.model.post

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.utils.Constants
import kotlinx.android.synthetic.main.item_post_layout.view.*


class PostAdapter(
    val postsList : List<Post>
):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
   inner class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    private var _onClickListener:OnClickListerner ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_post_layout,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var post = postsList.get(position)
        holder.itemView.apply {
            Glide.with(context)
                .load(post.thumbURL)
                .centerCrop()
                .into(img_post_thumb)

            tv_post_title.text = post.title
            tv_post_city.text = post.city
            tv_post_date.text = Constants.ConvertTimeStampToUnit(post.date)
            tv_post_username.text = post.username

            post_layout.setOnClickListener {
                if(_onClickListener != null){
                    _onClickListener!!.onClick(position,post)
                    Log.d(Constants.TAG,"2  Click!")
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    fun SetOnClickListerner(onClickListerner:OnClickListerner){
        this._onClickListener = onClickListerner
    }

    interface OnClickListerner{
        fun onClick(position:Int , post:Post)
    }
}