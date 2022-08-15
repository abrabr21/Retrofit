package com.example.retrofitv1.pojo

import android.icu.text.AlphabeticIndex
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback

data class Entity (
    @SerializedName("status") val status:String,
    @SerializedName("totalResults") val totalResults:Int,
    @SerializedName("articles") var articles:ArrayList<Article>
//smth
        )