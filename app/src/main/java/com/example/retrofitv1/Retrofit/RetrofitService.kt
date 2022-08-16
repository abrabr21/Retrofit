package com.example.retrofitv1.Retrofit

import retrofit2.Call
import com.example.retrofitv1.pojo.EntityResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    //top-headlines?country=us&category=business
    @GET("top-headlines")
    fun getArticlesList (
        @Query("country") country:String,
        @Query("category") category:String):Call<EntityResponse>

}