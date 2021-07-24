package com.example.harajtask.Repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.harajtask.model.Post
import com.example.harajtask.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PostRepository {

    companion object{
        fun getAllPosts(context: Context):List<Post>{
            val jsonData = Constants.readJsonFomAssets(context)
            Log.d(Constants.TAG,jsonData!!)

            val gson = Gson()
            val postType = object : TypeToken<List<Post>>() {}.type
            val postList : List<Post> = gson.fromJson(jsonData,postType)

            if(Constants.IS_TESTING){
                postList.forEach { post: Post? ->
                    Log.d(Constants.TAG,post!!.title)
                }
            }
            return postList
        }
    }

}