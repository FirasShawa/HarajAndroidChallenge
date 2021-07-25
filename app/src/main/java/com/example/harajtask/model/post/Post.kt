package com.example.harajtask.model.post
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("date")
    val date: Long,
    @SerializedName("thumbURL")
    val thumbURL: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("username")
    val username: String
): Parcelable