package com.example.retrofitv1.pojo

import com.google.gson.annotations.SerializedName

data class EntityResponse (
    @SerializedName("status") val status:String,
    @SerializedName("totalResults") val totalResults:Int,
    @SerializedName("articles") var articleResponses:List<ArticleResponse>

        )