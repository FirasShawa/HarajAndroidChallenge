package com.example.harajtask.utils

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.Repository.PostRepository
import com.example.harajtask.model.post.Post

class PostViewModel(
    val app: Application
):AndroidViewModel(app){

    var postLiveData : MutableLiveData<List<Post>> = MutableLiveData()

    fun getAllPosts():MutableLiveData<List<Post>>{
        postLiveData.postValue(PostRepository.getAllPosts(app.applicationContext))
        return postLiveData
    }
}