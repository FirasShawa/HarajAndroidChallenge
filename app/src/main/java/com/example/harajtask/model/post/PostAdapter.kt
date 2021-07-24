package com.example.harajtask.model.post

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.R
import kotlinx.android.synthetic.main.item_post_layout.view.*


class PostAdapter(
    val context: Context
):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
   inner class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)


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
        val post = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(context)
                .load(post.thumbURL)
                .centerCrop()
                .into(img_post_thumb)

            tv_post_title.text = post.title
            tv_post_city.text = post.city
            tv_post_date.text = post.date.toString()
            tv_post_username.text = post.username
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}