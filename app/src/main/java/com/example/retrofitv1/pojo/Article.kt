package com.example.retrofitv1.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import javax.xml.transform.Source

@Entity
data class Article (

    @SerializedName("source")
    @Expose
     var source: Source? = null,

    @SerializedName("author")
    @Expose
    @PrimaryKey
     var author: String? = null,

    @SerializedName("title")
    @Expose
     var title: String? = null,

    @SerializedName("description")
    @Expose
     var description: String? = null,

    @SerializedName("url")
    @Expose
     var url: String? = null,

    @SerializedName("urlToImage")
    @Expose
     var urlToImage: String? = null,

    @SerializedName("publishedAt")
    @Expose
     var publishedAt: String? = null,

    @SerializedName("content")
    @Expose
     var content: String? = null
    )