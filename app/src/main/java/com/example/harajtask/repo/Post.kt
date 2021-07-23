package com.example.harajtask.repo

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.harajtask.model.Post
import com.example.harajtask.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Post {

    companion object{
        fun readPosts(context: Context){
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


        }
    }

}