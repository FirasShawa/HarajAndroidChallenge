package com.example.harajtask.viewmodel.post

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harajtask.utils.PostViewModel

class PostViewModelProviderFactory(
    val app : Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(app) as T
    }
}