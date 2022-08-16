package com.example.retrofitv1.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import javax.xml.transform.Source


data class Article (

    @SerializedName("source")

     var source: SourceResponse? = null,

    @SerializedName("author")


     var author: String? = null,

    @SerializedName("title")

     var title: String? = null,

    @SerializedName("description")

     var description: String? = null,

    @SerializedName("url")

     var url: String? = null,

    @SerializedName("urlToImage")

     var urlToImage: String? = null,

    @SerializedName("publishedAt")

     var publishedAt: String? = null,

    @SerializedName("content")

     var content: String? = null
    )