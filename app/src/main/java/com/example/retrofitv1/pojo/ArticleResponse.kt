package com.example.retrofitv1.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import javax.xml.transform.Source

@Entity(tableName = "Articles")
data class ArticleResponse (



    @SerializedName("author")
    @ColumnInfo

     var author: String? = null,


    @SerializedName("title")
    @PrimaryKey
    val title: String,


    @SerializedName("description")
    @ColumnInfo
     var description: String? = null,

    @SerializedName("url")
    @ColumnInfo
     var url: String? = null,

    @SerializedName("urlToImage")
    @ColumnInfo
     var urlToImage: String? = null,

    @SerializedName("publishedAt")
    @ColumnInfo
     var publishedAt: String? = null,

    @SerializedName("content")
    @ColumnInfo
     var content: String? = null
    )