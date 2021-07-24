package com.example.harajtask.model.post
import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("date")
    val date: Int,
    @SerializedName("thumbURL")
    val thumbURL: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("username")
    val username: String
)